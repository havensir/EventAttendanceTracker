package com.joinup.ui;

import com.joinup.model.Attendee;
import com.joinup.model.Event;
import com.joinup.service.IAttendeeService;
import com.joinup.service.IEventService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/ui/events")
public class EventsController {

    private final IEventService events;
    private final IAttendeeService attendees;

    public EventsController(IEventService events, IAttendeeService attendees) {
        this.events = events;
        this.attendees = attendees;
    }

    /** List all events for the browse page. */
    @GetMapping
    public String list(Model model) {
        List<Event> all = events.listEvents();
        model.addAttribute("events", all);
        model.addAttribute("active", "events");
        model.addAttribute("hero", "Your city, your events.");
        return "events"; // your list template
    }

    /** Event details page showing metadata + attendee list + RSVP form. */
    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model, HttpSession session) {
        Event e = events.getEventById(id);
        if (e == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Event not found");
        }

        List<Attendee> rsvps = attendees.listByEventId(id);

        // If user is logged in, detect if they've already RSVP’d (by email)
        String me = session != null ? (String) session.getAttribute("userEmail") : null;
        boolean already = me != null && rsvps.stream().anyMatch(a ->
                a.getEmail() != null && a.getEmail().trim().equalsIgnoreCase(me));

        model.addAttribute("event", e);
        model.addAttribute("attendees", rsvps);
        model.addAttribute("alreadyRsvped", already);
        model.addAttribute("active", "events");
        model.addAttribute("hero", e.getName());
        return "event-detail";
    }

    /** Create (or reuse) an RSVP and go to a confirmation screen. */
    @PostMapping("/{id}/rsvp")
    public String rsvp(@PathVariable String id,
                       @RequestParam String firstName,
                       @RequestParam String lastName,
                       @RequestParam String email,
                       @RequestParam(required = false) String phone) {

        Event e = events.getEventById(id);
        if (e == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Event not found");
        }

        // Reuse ticket if this email already RSVP’d for this event
        Attendee existing = attendees.findByEventAndEmail(id, email);
        if (existing != null) {
            return "redirect:/ui/events/" + id + "/rsvp/confirm?attendeeId=" + existing.getId();
        }

        // Create a new attendee (id will be generated if null by service)
        Attendee a = new Attendee(null, firstName, lastName, email, id, phone);
        Attendee saved = attendees.registerAttendee(a);

        return "redirect:/ui/events/" + id + "/rsvp/confirm?attendeeId=" + saved.getId();
    }

    /** Confirmation screen after RSVP with CTA to view ticket or go back to event. */
    @GetMapping("/{id}/rsvp/confirm")
    public String confirm(@PathVariable String id,
                          @RequestParam String attendeeId,
                          Model model) {
        Event e = events.getEventById(id);
        if (e == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Event not found");
        }
        Attendee a = attendees.getById(attendeeId);
        if (a == null || !id.equals(a.getEventId())) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "RSVP not found");
        }

        model.addAttribute("event", e);
        model.addAttribute("attendee", a);
        model.addAttribute("active", "events");
        model.addAttribute("hero", "You're RSVP’d!");
        return "rsvp-confirm";
    }

    /** “My Tickets” page (lists RSVPs for the logged-in user’s email). */
    @GetMapping("/my")
    public String myTickets(Model model, HttpSession session) {
        String me = session != null ? (String) session.getAttribute("userEmail") : null;
        List<Attendee> mine = (me == null || me.isBlank()) ? List.of() : attendees.listByEmail(me);

        model.addAttribute("myTickets", mine);
        model.addAttribute("events", events.listEvents()); // for resolving event names
        model.addAttribute("active", "tickets");
        model.addAttribute("hero", "Your Tickets");
        return "tickets";
    }
}

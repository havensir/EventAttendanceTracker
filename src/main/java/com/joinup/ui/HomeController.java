package com.joinup.ui;

import com.joinup.model.Attendee;
import com.joinup.model.Event;
import com.joinup.service.IAttendeeService;
import com.joinup.service.IEventService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final IEventService events;
    private final IAttendeeService attendees;

    public HomeController(IEventService events, IAttendeeService attendees) {
        this.events = events;
        this.attendees = attendees;
    }

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        // featured events (use all for now)
        List<Event> all = events.listEvents();
        Map<String, Event> eventsById = all.stream().collect(Collectors.toMap(Event::getId, e -> e));

        // tickets for the current user (by email in session)
        String email = session != null ? (String) session.getAttribute("userEmail") : null;
        List<Attendee> mine = (email == null || email.isBlank())
                ? List.of()
                : attendees.listByEmail(email);

        model.addAttribute("events", all);
        model.addAttribute("eventsById", eventsById);
        model.addAttribute("attendees", mine);

        // used in hero greeting
        model.addAttribute("userName", session != null ? session.getAttribute("userName") : null);

        model.addAttribute("active", "home");
        return "index"; // this is the template you pasted
    }
}

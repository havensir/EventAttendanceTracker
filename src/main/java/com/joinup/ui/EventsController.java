package com.joinup.ui;

import com.joinup.model.Event;
import com.joinup.service.IEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EventsController {

    private final IEventService eventService;

    public EventsController(IEventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/ui/events")
    public String events(Model model) {
        List<Event> events = eventService.listEvents();
        model.addAttribute("events", events);

        // Optional demo identity in the sidebar (shell reads these)
        model.addAttribute("userName", "Jane Doe");
        model.addAttribute("userOrg",  "XYZ Company");

        // Shell args
        model.addAttribute("active",   "events");
        model.addAttribute("pageTitle","Events");

        return "events"; // templates/events.html
    }
}

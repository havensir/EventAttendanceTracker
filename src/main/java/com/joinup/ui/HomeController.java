package com.joinup.ui;

import com.joinup.model.Event;
import com.joinup.service.IEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * UI layer (server-rendered) entrypoint.
 * Renders templates from src/main/resources/templates (Thymeleaf).
 */
@Controller
public class HomeController {

    private final IEventService eventService;

    public HomeController(IEventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Example: pass some initial data to the template. This can be empty if you prefer.
        List<Event> events = eventService.listEvents();
        model.addAttribute("events", events);
        model.addAttribute("appName", "JoinUp (EventAttendanceTracker)");
        return "index"; // resolves templates/index.html
    }

    @GetMapping("/ui/mock-tester")
    public String mockTester() {
        // Serve the API tester UI from templates as well (SPA-like but server served)
        return "mock-fetch";
    }
}

package com.joinup.ui;

import com.joinup.model.Attendee;
import com.joinup.model.CheckIn;
import com.joinup.model.Event;
import com.joinup.service.IAttendeeService;
import com.joinup.service.ICheckInService;
import com.joinup.service.IEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final IEventService eventService;
    private final IAttendeeService attendeeService;
    private final ICheckInService checkInService;

    public HomeController(IEventService eventService,
                          IAttendeeService attendeeService,
                          ICheckInService checkInService) {
        this.eventService = eventService;
        this.attendeeService = attendeeService;
        this.checkInService = checkInService;
    }

    @GetMapping("/")
    public String home(Model model) {
        String userName = "Alex Rivera";
        String userOrg  = "Skyline Innovations";

        List<Event> events = eventService.listEvents();
        List<Attendee> attendees = attendeeService.listAttendees();
        List<CheckIn> checkIns = checkInService.listCheckIns();

        Map<String, Event> eventsById = events.stream()
            .collect(Collectors.toMap(
                Event::getId,
                Function.identity(),
                (a, b) -> a,
                LinkedHashMap::new
            ));

        model.addAttribute("userName", userName);
        model.addAttribute("userOrg", userOrg);
        model.addAttribute("events", events);
        model.addAttribute("attendees", attendees);
        model.addAttribute("checkIns", checkIns);
        model.addAttribute("eventsById", eventsById);
        model.addAttribute("pageTitle", "JoinUp • Home");

        return "index";
    }

    /** ✅ Keep the API tester route separate */
    @GetMapping("/ui/mock-tester")
    public String mockTester(Model model) {
        model.addAttribute("pageTitle", "JoinUp • API Tester");
        return "mock-fetch"; // resolves templates/mock-fetch.html
    }
}

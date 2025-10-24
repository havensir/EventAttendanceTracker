package com.joinup.config;

import com.joinup.model.Attendee;
import com.joinup.model.CheckIn;
import com.joinup.model.Event;
import com.joinup.service.IAttendeeService;
import com.joinup.service.ICheckInService;
import com.joinup.service.IEventService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedConfig {

    @Bean
    CommandLineRunner seedData(IEventService events, IAttendeeService attendees, ICheckInService checkins) {
        return args -> {
            boolean needEvents   = (events instanceof com.joinup.service.impl.EventServiceImpl e) && e.isEmpty();
            boolean needAtts     = (attendees instanceof com.joinup.service.impl.AttendeeServiceImpl a) && a.isEmpty();
            boolean needCheckins = (checkins instanceof com.joinup.service.impl.CheckInServiceImpl c) && c.isEmpty();

            if (!(needEvents || needAtts || needCheckins)) return;

            // Seed Events
            Event e1 = events.createEvent(new Event("E-001", "Welcome Mixer", "2025-11-05T18:00:00-04:00", "Student Center Atrium", 150));
            Event e2 = events.createEvent(new Event("E-002", "Hack Night",     "2025-11-12T19:00:00-04:00", "Scioto Hall 9F Lounge", 60));
            Event e3 = events.createEvent(new Event("E-003", "Career Panel",   "2025-11-20T17:30:00-04:00", "Engineering 427", 120));

            // Seed Attendees
            Attendee a1 = attendees.registerAttendee(new Attendee("A-101", "Ava",   "Thompson", "ava@example.com",   e1.getId(), "123456789"));
            Attendee a2 = attendees.registerAttendee(new Attendee("A-102", "Juwan", "Carter",   "juwan@example.com", e1.getId(), "987654321"));
            Attendee a3 = attendees.registerAttendee(new Attendee("A-103", "Moussa","Diallo",   "moussa@example.com",e2.getId(), "111222333"));

            // Seed Check-ins
            checkins.create(new CheckIn("CI-9001", a1.getId(), e1.getId(), "2025-11-05T18:05:12-04:00", "success"));
            checkins.create(new CheckIn("CI-9002", a2.getId(), e1.getId(), "2025-11-05T18:17:49-04:00", "success"));
            checkins.create(new CheckIn("CI-9003", a3.getId(), e2.getId(), "2025-11-12T19:03:01-04:00", "success"));
        };
    }
}

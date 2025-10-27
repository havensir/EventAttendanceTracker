package com.joinup.config;

import com.joinup.model.*;
import com.joinup.service.*;
import com.joinup.dao.IUserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedConfig {

    @Bean
    CommandLineRunner seedData(
            IEventService events,
            IAttendeeService attendees,
            ICheckInService checkins,
            IUserDao users) {

        return args -> {
            boolean needEvents   = (events instanceof com.joinup.service.impl.EventServiceImpl e) && e.isEmpty();
            boolean needAtts     = (attendees instanceof com.joinup.service.impl.AttendeeServiceImpl a) && a.isEmpty();
            boolean needCheckins = (checkins instanceof com.joinup.service.impl.CheckInServiceImpl c) && c.isEmpty();
            boolean needUsers    = users.count() == 0;

            if (!(needEvents || needAtts || needCheckins || needUsers)) return;

            // 🌟 Users (first/last + role)
            if (needUsers) {
                users.save(new User(null, "Alex",   "Chen",   "Kroger",                   "alex.chen@kroger.com",     "513-555-1101", Role.ADMIN));
                users.save(new User(null, "Jordan", "Patel",  "University of Cincinnati", "jordan.patel@uc.edu",      "513-555-2244", Role.USER));
                users.save(new User(null, "Morgan", "Rivera", "JoinUp",                   "morgan.rivera@joinup.io",  "513-555-7788", Role.USER));
                users.save(new User(null, "Taylor", "Quinn",  "Bearcat Labs",             "taylor@bearcatlabs.io",    "513-555-9900", Role.SUPER_ADMIN));
                users.save(new User(null, "Riley",  "Johnson","Procter & Gamble",         "riley.j@pg.com",           "513-555-4412", Role.USER));
            }

            // 🎟️ Events
            Event e1 = events.createEvent(new Event("E-001", "Welcome Mixer", "2025-11-05T18:00:00-04:00", "Student Center Atrium", 150));
            Event e2 = events.createEvent(new Event("E-002", "Hack Night",     "2025-11-12T19:00:00-04:00", "Scioto Hall 9F Lounge", 60));
            Event e3 = events.createEvent(new Event("E-003", "Career Panel",   "2025-11-20T17:30:00-04:00", "Engineering 427", 120));
            Event e4 = events.createEvent(new Event("E-004", "Holiday Gala",   "2025-12-10T19:00:00-05:00", "Great Hall", 200));
            Event e5 = events.createEvent(new Event("E-005", "Tech Talk: AI & UX", "2026-01-15T18:00:00-05:00", "Zimmer Auditorium", 90));

            // 🧍 Attendees
            Attendee a1 = attendees.registerAttendee(new Attendee("A-101", "Ava",   "Thompson", "ava@example.com",   e1.getId(), "123456789"));
            Attendee a2 = attendees.registerAttendee(new Attendee("A-102", "Juwan", "Carter",   "juwan@example.com", e1.getId(), "987654321"));
            Attendee a3 = attendees.registerAttendee(new Attendee("A-103", "Moussa","Diallo",   "moussa@example.com",e2.getId(), "111222333"));
            Attendee a4 = attendees.registerAttendee(new Attendee("A-104", "Abi",   "Patel",    "abi@example.com",   e3.getId(), "444555666"));
            Attendee a5 = attendees.registerAttendee(new Attendee("A-105", "Luke",  "Rivera",   "luke@example.com",  e4.getId(), "777888999"));
            Attendee a6 = attendees.registerAttendee(new Attendee("A-106", "Harsh", "Mehta",    "harsh@example.com", e5.getId(), "101202303"));

            // ✅ Check-ins
            checkins.create(new CheckIn("CI-9001", a1.getId(), e1.getId(), "2025-11-05T18:05:12-04:00", "success"));
            checkins.create(new CheckIn("CI-9002", a2.getId(), e1.getId(), "2025-11-05T18:17:49-04:00", "success"));
            checkins.create(new CheckIn("CI-9003", a3.getId(), e2.getId(), "2025-11-12T19:03:01-04:00", "success"));
            checkins.create(new CheckIn("CI-9004", a4.getId(), e3.getId(), "2025-11-20T17:33:10-04:00", "success"));
            checkins.create(new CheckIn("CI-9005", a5.getId(), e4.getId(), "2025-12-10T19:08:00-05:00", "success"));
            checkins.create(new CheckIn("CI-9006", a6.getId(), e5.getId(), "2026-01-15T18:04:27-05:00", "success"));
        };
    }
}

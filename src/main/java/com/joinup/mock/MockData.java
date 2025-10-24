package com.joinup.mock;

import com.joinup.model.Attendee;
import com.joinup.model.CheckIn;
import com.joinup.model.Event;

import java.util.Arrays;
import java.util.List;

/** Centralized mock data for Milestone 1 connectivity. */
public final class MockData {
    private MockData() {}

    public static List<Event> events() {
        return Arrays.asList(
            new Event("E-001", "Welcome Mixer", "2025-11-05T18:00:00-04:00", "Student Center Atrium", 150),
            new Event("E-002", "Hack Night",     "2025-11-12T19:00:00-04:00", "Scioto Hall 9F Lounge", 60),
            new Event("E-003", "Career Panel",   "2025-11-20T17:30:00-04:00", "Engineering 427", 120)
        );
    }

    public static List<Attendee> attendees() {
        return Arrays.asList(
            new Attendee("A-101", "Ava",    "Thompson", "ava@example.com",    "E-001", "123456789"),
            new Attendee("A-102", "Juwan",  "Carter",   "juwan@example.com",  "E-001", "987654321"),
            new Attendee("A-103", "Moussa", "Diallo",   "moussa@example.com", "E-002", "111222333")
        );
    }

    public static List<CheckIn> checkIns() {
        return Arrays.asList(
            new CheckIn("CI-9001", "A-101", "E-001", "2025-11-05T18:05:12-04:00", "success"),
            new CheckIn("CI-9002", "A-102", "E-001", "2025-11-05T18:17:49-04:00", "success"),
            new CheckIn("CI-9003", "A-103", "E-002", "2025-11-12T19:03:01-04:00", "success")
        );
    }
}

package com.joinup.service.impl;

import com.joinup.model.Attendee;
import com.joinup.service.IAttendeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AttendeeServiceImpl implements IAttendeeService {

    private final Map<String, Attendee> attendees = new ConcurrentHashMap<>();

    @Override
    public List<Attendee> listAttendees() {
        return new ArrayList<>(attendees.values());
    }

    @Override
    public Attendee registerAttendee(Attendee attendee) {
        if (attendee.getId() == null || attendee.getId().isBlank()) {
            attendee.id = "A-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        }
        attendees.put(attendee.getId(), attendee);
        return attendee;
    }

    // convenience for seeder/tests
    public boolean isEmpty() {
        return attendees.isEmpty();
    }
}

package com.joinup.service.impl;

import com.joinup.model.Attendee;
import com.joinup.service.IAttendeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class AttendeeServiceImpl implements IAttendeeService {

    // In-memory store; replace with DAO/JPA later.
    // key = attendee id
    private final Map<String, Attendee> store = new ConcurrentHashMap<>();

    @Override
    public Attendee registerAttendee(Attendee attendee) {
        if (attendee.getId() == null || attendee.getId().isBlank()) {
            attendee.setId("A-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        store.put(attendee.getId(), attendee);
        return attendee;
    }

    @Override
    public List<Attendee> listAttendees() {
        return store.values().stream()
                .sorted(Comparator
                        .comparing(Attendee::getEventId, Comparator.nullsLast(String::compareTo))
                        .thenComparing(Attendee::getLastName, Comparator.nullsLast(String::compareTo))
                        .thenComparing(Attendee::getFirstName, Comparator.nullsLast(String::compareTo)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Attendee> listByEventId(String eventId) {
        return store.values().stream()
                .filter(a -> Objects.equals(eventId, a.getEventId()))
                .sorted(Comparator
                        .comparing(Attendee::getLastName, Comparator.nullsLast(String::compareTo))
                        .thenComparing(Attendee::getFirstName, Comparator.nullsLast(String::compareTo)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Attendee> listByEmail(String email) {
        if (email == null) return List.of();
        String norm = email.trim().toLowerCase();
        return store.values().stream()
                .filter(a -> a.getEmail() != null && a.getEmail().trim().toLowerCase().equals(norm))
                .sorted(Comparator.comparing(Attendee::getEventId, Comparator.nullsLast(String::compareTo)))
                .collect(Collectors.toList());
    }

    @Override
    public Attendee findByEventAndEmail(String eventId, String email) {
        if (eventId == null || email == null) return null;
        String norm = email.trim().toLowerCase();
        return store.values().stream()
                .filter(a -> eventId.equals(a.getEventId())
                        && a.getEmail() != null
                        && a.getEmail().trim().toLowerCase().equals(norm))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Attendee getById(String attendeeId) {
        return attendeeId == null ? null : store.get(attendeeId);
    }

    // convenience for seeding/tests
    public boolean isEmpty() { return store.isEmpty(); }
}

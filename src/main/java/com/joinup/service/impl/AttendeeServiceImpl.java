package com.joinup.service.impl;

import com.joinup.model.Attendee;
import com.joinup.service.IAttendeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Implementation of {@link IAttendeeService} that manages attendee registration and retrieval
 * using an in-memory data store.
 * 
 * <p>This implementation uses a {@link ConcurrentHashMap} for thread-safe operations
 * and automatically generates unique attendee IDs when not provided.</p>
 * 
 * <p><strong>Note:</strong> This is a temporary in-memory implementation.
 * In production, this should be replaced with a proper database layer using JPA/Hibernate.</p>
 * 
 * @author JoinUp Development Team
 * @version 1.0
 * @since 1.0
 */
@Service
public class AttendeeServiceImpl implements IAttendeeService {

    /**
     * In-memory store for attendee data.
     * Key: attendee ID (String), Value: Attendee object
     * 
     * <p>Uses ConcurrentHashMap for thread-safety in multi-user scenarios.
     * This will be replaced with a proper database layer in future iterations.</p>
     */
    private final Map<String, Attendee> store = new ConcurrentHashMap<>();

    /**
     * Registers a new attendee for an event or updates an existing one.
     * 
     * <p>If the attendee ID is null or blank, a new unique ID will be automatically
     * generated using the format "A-{8-character-UUID}".</p>
     * 
     * @param attendee the attendee to register (must not be null)
     * @return the registered attendee with a guaranteed non-null ID
     * @throws IllegalArgumentException if attendee is null
     */
    @Override
    public Attendee registerAttendee(Attendee attendee) {
        if (attendee == null) {
            throw new IllegalArgumentException("Attendee cannot be null");
        }
        
        if (attendee.getId() == null || attendee.getId().isBlank()) {
            attendee.setId("A-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        store.put(attendee.getId(), attendee);
        return attendee;
    }

    /**
     * Retrieves all registered attendees sorted by event ID, then by last name, then by first name.
     * 
     * <p>The sorting order ensures consistent presentation of attendee lists
     * and groups attendees by their associated events.</p>
     * 
     * @return an immutable list of all attendees, sorted as described above
     */
    @Override
    public List<Attendee> listAttendees() {
        return store.values().stream()
                .sorted(Comparator
                        .comparing(Attendee::getEventId, Comparator.nullsLast(String::compareTo))
                        .thenComparing(Attendee::getLastName, Comparator.nullsLast(String::compareTo))
                        .thenComparing(Attendee::getFirstName, Comparator.nullsLast(String::compareTo)))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all attendees registered for a specific event.
     * 
     * <p>Results are sorted alphabetically by last name, then first name
     * for consistent presentation within an event's attendee list.</p>
     * 
     * @param eventId the ID of the event to filter by (null values are handled gracefully)
     * @return a list of attendees for the specified event, or empty list if event has no attendees
     */
    @Override
    public List<Attendee> listByEventId(String eventId) {
        return store.values().stream()
                .filter(a -> Objects.equals(eventId, a.getEventId()))
                .sorted(Comparator
                        .comparing(Attendee::getLastName, Comparator.nullsLast(String::compareTo))
                        .thenComparing(Attendee::getFirstName, Comparator.nullsLast(String::compareTo)))
                .collect(Collectors.toList());
    }

    /**
     * Finds all attendees with the specified email address.
     * 
     * <p>Email comparison is case-insensitive and handles null/empty values gracefully.
     * Results are sorted by event ID to group multiple registrations by the same person.</p>
     * 
     * @param email the email address to search for (null or empty values return empty list)
     * @return a list of attendees with the matching email, sorted by event ID
     */
    @Override
    public List<Attendee> listByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return List.of();
        }
        String normalizedEmail = email.trim().toLowerCase();
        return store.values().stream()
                .filter(a -> a.getEmail() != null && a.getEmail().trim().toLowerCase().equals(normalizedEmail))
                .sorted(Comparator.comparing(Attendee::getEventId, Comparator.nullsLast(String::compareTo)))
                .collect(Collectors.toList());
    }

    /**
     * Finds a specific attendee by event ID and email address combination.
     * 
     * <p>This method is useful for checking if someone has already registered
     * for a specific event. Email comparison is case-insensitive.</p>
     * 
     * @param eventId the ID of the event (null returns null)
     * @param email the email address to search for (null returns null)
     * @return the attendee if found, or null if no match exists
     */
    @Override
    public Attendee findByEventAndEmail(String eventId, String email) {
        if (eventId == null || email == null || email.trim().isEmpty()) {
            return null;
        }
        String normalizedEmail = email.trim().toLowerCase();
        return store.values().stream()
                .filter(a -> eventId.equals(a.getEventId())
                        && a.getEmail() != null
                        && a.getEmail().trim().toLowerCase().equals(normalizedEmail))
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves an attendee by their unique ID.
     * 
     * @param attendeeId the unique attendee identifier (null returns null)
     * @return the attendee if found, or null if not found or attendeeId is null
     */
    @Override
    public Attendee getById(String attendeeId) {
        return attendeeId == null ? null : store.get(attendeeId);
    }

    /**
     * Checks if the attendee store is empty.
     * 
     * <p>This method is primarily used for testing and data seeding purposes
     * to determine if sample data should be loaded.</p>
     * 
     * @return true if no attendees are stored, false otherwise
     */
    public boolean isEmpty() { 
        return store.isEmpty(); 
    }
}

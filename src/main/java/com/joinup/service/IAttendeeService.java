package com.joinup.service;

import com.joinup.model.Attendee;
import java.util.List;

public interface IAttendeeService {
    /** Create or upsert an attendee (used by RSVP). */
    Attendee registerAttendee(Attendee attendee);

    /** List all attendees (handy for testing/diagnostics). */
    List<Attendee> listAttendees();

    /** List attendees for a given event id (used by event details). */
    List<Attendee> listByEventId(String eventId);

    /** List a user's RSVPs (tickets) by their email (used by "My Tickets"). */
    List<Attendee> listByEmail(String email);

    /** Find a single attendee ticket for (eventId, email) pair (prevents dup RSVP). */
    Attendee findByEventAndEmail(String eventId, String email);

    /** Direct lookup by attendee id (used by RSVP confirmation + ticket page). */
    Attendee getById(String attendeeId);
}



/** Refactored Interface (Better Naming + JavaDoc) **/

package com.joinup.service;

import com.joinup.model.Attendee;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing attendee operations.
 * Provides methods for registration, retrieval, and listing attendees.
 */
public interface AttendeeService {

    /**
     * Registers or updates an attendee (used by RSVP).
     *
     * @param attendee Attendee object to register
     * @return Registered attendee
     * @throws IllegalArgumentException if attendee is null
     */
    Attendee registerAttendee(Attendee attendee);

    /**
     * Lists all attendees.
     *
     * @return List of all attendees
     */
    List<Attendee> listAttendees();

    /**
     * Lists attendees for a given event ID.
     *
     * @param eventId Event identifier
     * @return List of attendees for the event
     */
    List<Attendee> listByEventId(String eventId);

    /**
     * Lists a user's RSVPs by their email.
     *
     * @param email User's email
     * @return List of RSVPs
     */
    List<Attendee> listByEmail(String email);

    /**
     * Finds an attendee ticket for a (eventId, email) pair.
     *
     * @param eventId Event identifier
     * @param email User's email
     * @return Optional containing the attendee if found
     */
    Optional<Attendee> findByEventAndEmail(String eventId, String email);

    /**
     * Retrieves an attendee by ID.
     *
     * @param attendeeId Attendee identifier
     * @return Optional containing the attendee if found
     */
    Optional<Attendee> getById(String attendeeId);
}

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

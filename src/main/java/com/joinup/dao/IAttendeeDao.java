package com.joinup.dao;

import com.joinup.model.Attendee;
import java.util.List;

public interface IAttendeeDao {
    List<Attendee> getAllAttendees();
    Attendee getAttendeeById(int id);
    void registerAttendee(Attendee attendee);
}

/** Refactored version **/

package com.joinup.dao;

import com.joinup.model.Attendee;
import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for managing Attendee entities.
 * Provides methods for retrieving and registering attendees.
 */
public interface AttendeeDao {

    /**
     * Retrieves all attendees from the database.
     *
     * @return List of all attendees
     */
    List<Attendee> findAll();

    /**
     * Retrieves an attendee by their unique ID.
     *
     * @param id Unique identifier of the attendee
     * @return Optional containing the attendee if found, otherwise empty
     */
    Optional<Attendee> findById(int id);

    /**
     * Registers a new attendee in the database.
     *
     * @param attendee Attendee object to register
     */
    void save(Attendee attendee);
}

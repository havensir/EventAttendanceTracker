package com.joinup.model;

import java.util.Objects;

/**
 * Represents an event in the JoinUp attendance tracking system.
 * 
 * <p>An event contains essential information such as name, date/time, location,
 * and capacity constraints. This class serves as the core domain model for
 * event management and attendance tracking.</p>
 * 
 * <p>Events are identified by a unique string ID following the format "E-XXX"
 * where XXX is a sequential number or identifier.</p>
 * 
 * @author JoinUp Development Team
 * @version 1.0
 * @since 1.0
 */
public class Event {
    private String id;
    private String name;
    private String dateTime;
    private String location;
    private Integer capacity;

    /**
     * Default constructor for Event.
     * Creates an event with all fields uninitialized.
     */
    public Event() {}

    /**
     * Constructs a new Event with the specified details.
     * 
     * @param id the unique identifier for this event (should not be null or empty)
     * @param name the display name of the event (should not be null or empty)
     * @param dateTime the date and time of the event in ISO 8601 format
     * @param location the venue or location where the event takes place
     * @param capacity the maximum number of attendees allowed (should be positive)
     * @throws IllegalArgumentException if any required parameter is invalid
     */
    public Event(String id, String name, String dateTime, String location, Integer capacity) {
        this.setId(id);
        this.setName(name);
        this.setDateTime(dateTime);
        this.setLocation(location);
        this.setCapacity(capacity);
    }

    /**
     * Gets the unique identifier for this event.
     * @return the event ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this event.
     * @param id the event ID (should not be null or empty for persistent events)
     * @throws IllegalArgumentException if id is null or empty string
     */
    public void setId(String id) {
        if (id != null && id.trim().isEmpty()) {
            throw new IllegalArgumentException("Event ID cannot be empty");
        }
        this.id = id;
    }

    /**
     * Gets the display name of this event.
     * @return the event name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the display name of this event.
     * @param name the event name (should not be null or empty)
     * @throws IllegalArgumentException if name is null or empty
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Event name cannot be null or empty");
        }
        this.name = name.trim();
    }

    /**
     * Gets the date and time when this event occurs.
     * @return the event date/time in ISO 8601 format
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Sets the date and time when this event occurs.
     * @param dateTime the event date/time (should be in ISO 8601 format)
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Gets the location where this event takes place.
     * @return the event location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location where this event takes place.
     * @param location the event location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the maximum capacity for this event.
     * @return the maximum number of attendees allowed
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * Sets the maximum capacity for this event.
     * @param capacity the maximum number of attendees (should be positive)
     * @throws IllegalArgumentException if capacity is negative
     */
    public void setCapacity(Integer capacity) {
        if (capacity != null && capacity < 0) {
            throw new IllegalArgumentException("Event capacity cannot be negative");
        }
        this.capacity = capacity;
    }

    /**
     * Checks if this event has reached its capacity based on the number of registered attendees.
     * @param currentAttendeeCount the current number of registered attendees
     * @return true if the event is at or over capacity, false otherwise
     */
    public boolean isAtCapacity(int currentAttendeeCount) {
        return capacity != null && currentAttendeeCount >= capacity;
    }

    /**
     * Gets the number of available spots remaining for this event.
     * @param currentAttendeeCount the current number of registered attendees
     * @return the number of spots remaining, or null if capacity is unlimited
     */
    public Integer getAvailableSpots(int currentAttendeeCount) {
        return capacity != null ? Math.max(0, capacity - currentAttendeeCount) : null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event event = (Event) obj;
        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
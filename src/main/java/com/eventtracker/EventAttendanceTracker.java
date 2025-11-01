/**
 * EventAttendanceTracker is responsible for managing event attendees.
 * It provides functionality to register, remove, and list attendees.
 */
public class EventAttendanceTracker {

    /**
     * Registers a new attendee for the event.
     *
     * @param attendeeName Name of the attendee
     * @throws IllegalArgumentException if attendeeName is null or empty
     */
    public void registerAttendance(String attendeeName) {
        if (attendeeName == null || attendeeName.isEmpty()) {
            throw new IllegalArgumentException("Attendee name cannot be null or empty");
        }
        // existing logic
    }

    /**
     * Removes an attendee from the event.
     *
     * @param attendeeName Name of the attendee to remove
     */
    public void removeAttendance(String attendeeName) {
        // existing logic
    }
}

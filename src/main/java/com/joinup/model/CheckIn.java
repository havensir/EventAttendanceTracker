package com.joinup.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 * Represents a check-in record for an attendee at a specific event.
 * 
 * <p>This class captures the essential information about when and how
 * an attendee checked into an event, including the timestamp, status,
 * and method used for check-in (QR code or manual entry).</p>
 * 
 * <p>Check-in IDs follow the format "CI-XXXX" where XXXX is a unique identifier.</p>
 * 
 * @author JoinUp Development Team
 * @version 1.0
 * @since 1.0
 */
public class CheckIn {
    
    /**
     * Enumeration of possible check-in statuses.
     */
    public enum Status {
        /** Check-in was successful */
        SUCCESS("success"),
        /** Attendee attempted to check in again (duplicate) */
        DUPLICATE("duplicate"),
        /** Invalid ticket or attendee information */
        INVALID("invalid");
        
        private final String value;
        
        Status(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
        
        /**
         * Converts a string value to the corresponding Status enum.
         * @param value the string representation
         * @return the matching Status, or null if no match found
         */
        public static Status fromValue(String value) {
            if (value == null) return null;
            for (Status status : values()) {
                if (status.value.equalsIgnoreCase(value.trim())) {
                    return status;
                }
            }
            return null;
        }
    }
    
    /**
     * Enumeration of possible check-in methods.
     */
    public enum Method {
        /** Check-in via QR code scan */
        QR("QR"),
        /** Manual check-in by staff */
        MANUAL("manual");
        
        private final String value;
        
        Method(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
        
        /**
         * Converts a string value to the corresponding Method enum.
         * @param value the string representation
         * @return the matching Method, or null if no match found
         */
        public static Method fromValue(String value) {
            if (value == null) return null;
            for (Method method : values()) {
                if (method.value.equalsIgnoreCase(value.trim())) {
                    return method;
                }
            }
            return null;
        }
    }

    private String checkInId;
    private String attendeeId;
    private String eventId;
    private String timestamp;
    private Status status;
    private Method method;

    /**
     * Default constructor for CheckIn.
     */
    public CheckIn() {}

    /**
     * Constructs a new CheckIn with the specified details.
     * 
     * @param checkInId unique identifier for this check-in record
     * @param attendeeId the ID of the attendee checking in
     * @param eventId the ID of the event being attended
     * @param timestamp the date/time of check-in in ISO 8601 format
     * @param status the result status of the check-in attempt
     * @throws IllegalArgumentException if any required parameter is invalid
     */
    public CheckIn(String checkInId, String attendeeId, String eventId, String timestamp, String status) {
        this(checkInId, attendeeId, eventId, timestamp, status, null);
    }

    /**
     * Constructs a new CheckIn with the specified details including method.
     * 
     * @param checkInId unique identifier for this check-in record
     * @param attendeeId the ID of the attendee checking in
     * @param eventId the ID of the event being attended
     * @param timestamp the date/time of check-in in ISO 8601 format
     * @param status the result status of the check-in attempt
     * @param method the method used for check-in (QR or manual)
     * @throws IllegalArgumentException if any required parameter is invalid
     */
    public CheckIn(String checkInId, String attendeeId, String eventId, String timestamp, 
                   String status, String method) {
        this.setCheckInId(checkInId);
        this.setAttendeeId(attendeeId);
        this.setEventId(eventId);
        this.setTimestamp(timestamp);
        this.setStatus(status);
        this.setMethod(method);
    }

    /**
     * Gets the unique identifier for this check-in record.
     * @return the check-in ID
     */
    public String getCheckInId() {
        return checkInId;
    }

    /**
     * Sets the unique identifier for this check-in record.
     * @param checkInId the check-in ID (should not be null or empty)
     * @throws IllegalArgumentException if checkInId is null or empty
     */
    public void setCheckInId(String checkInId) {
        if (checkInId == null || checkInId.trim().isEmpty()) {
            throw new IllegalArgumentException("Check-in ID cannot be null or empty");
        }
        this.checkInId = checkInId.trim();
    }

    /**
     * Gets the ID of the attendee who checked in.
     * @return the attendee ID
     */
    public String getAttendeeId() {
        return attendeeId;
    }

    /**
     * Sets the ID of the attendee who checked in.
     * @param attendeeId the attendee ID (should not be null or empty)
     * @throws IllegalArgumentException if attendeeId is null or empty
     */
    public void setAttendeeId(String attendeeId) {
        if (attendeeId == null || attendeeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Attendee ID cannot be null or empty");
        }
        this.attendeeId = attendeeId.trim();
    }

    /**
     * Gets the ID of the event being attended.
     * @return the event ID
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * Sets the ID of the event being attended.
     * @param eventId the event ID (should not be null or empty)
     * @throws IllegalArgumentException if eventId is null or empty
     */
    public void setEventId(String eventId) {
        if (eventId == null || eventId.trim().isEmpty()) {
            throw new IllegalArgumentException("Event ID cannot be null or empty");
        }
        this.eventId = eventId.trim();
    }

    /**
     * Gets the timestamp when the check-in occurred.
     * @return the timestamp in ISO 8601 format
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp when the check-in occurred.
     * @param timestamp the timestamp in ISO 8601 format
     * @throws IllegalArgumentException if timestamp format is invalid
     */
    public void setTimestamp(String timestamp) {
        if (timestamp != null && !timestamp.trim().isEmpty()) {
            validateTimestampFormat(timestamp);
        }
        this.timestamp = timestamp;
    }

    /**
     * Gets the status of this check-in attempt.
     * @return the check-in status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Gets the status as a string value for backward compatibility.
     * @return the status string value
     */
    public String getStatusValue() {
        return status != null ? status.getValue() : null;
    }

    /**
     * Sets the status of this check-in attempt.
     * @param status the check-in status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Sets the status from a string value for backward compatibility.
     * @param status the status string value
     */
    public void setStatus(String status) {
        this.status = Status.fromValue(status);
    }

    /**
     * Gets the method used for this check-in.
     * @return the check-in method
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Gets the method as a string value for backward compatibility.
     * @return the method string value
     */
    public String getMethodValue() {
        return method != null ? method.getValue() : null;
    }

    /**
     * Sets the method used for this check-in.
     * @param method the check-in method
     */
    public void setMethod(Method method) {
        this.method = method;
    }

    /**
     * Sets the method from a string value for backward compatibility.
     * @param method the method string value
     */
    public void setMethod(String method) {
        this.method = Method.fromValue(method);
    }

    /**
     * Validates that the timestamp is in a parseable ISO 8601 format.
     * @param timestamp the timestamp to validate
     * @throws IllegalArgumentException if the timestamp format is invalid
     */
    private void validateTimestampFormat(String timestamp) {
        try {
            LocalDateTime.parse(timestamp.substring(0, Math.min(timestamp.length(), 19)),
                              DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid timestamp format. Expected ISO 8601 format.", e);
        }
    }

    /**
     * Checks if this check-in was successful.
     * @return true if status is SUCCESS, false otherwise
     */
    public boolean isSuccessful() {
        return Status.SUCCESS.equals(status);
    }

    /**
     * Checks if this check-in was done via QR code.
     * @return true if method is QR, false otherwise
     */
    public boolean isQrCheckIn() {
        return Method.QR.equals(method);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CheckIn checkIn = (CheckIn) obj;
        return Objects.equals(checkInId, checkIn.checkInId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkInId);
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "checkInId='" + checkInId + '\'' +
                ", attendeeId='" + attendeeId + '\'' +
                ", eventId='" + eventId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", status=" + status +
                ", method=" + method +
                '}';
    }
}
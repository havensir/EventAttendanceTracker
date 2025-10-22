package com.joinup.model;

// TODO: add fields for check-in data
public class CheckIn {
    public String checkInId;
    public String attendeeId;
    public String eventId;
    public String timestamp;
    public String status; // success | duplicate | invalid

    public CheckIn(String checkInId, String attendeeId, String eventId, String timestamp, String status){
        this.checkInId = checkInId;
        this.attendeeId = attendeeId;
        this.eventId = eventId;
        this.timestamp = timestamp;
        this.status = status;
    }

    public String getCheckInId() {return checkInId; }
    public String getAttendeeId() {return attendeeId; }
    public String getEventId() {return eventId; }
    public String getTimestamp() {return timestamp; }
    public String getStatus() {return status; }
}
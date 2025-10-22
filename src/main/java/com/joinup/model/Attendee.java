package com.joinup.model;

// TODO: add fields for attendee info
public class Attendee {
    public String id;
    public String firstName;
    public String lastName;
    public String email;
    public String eventId;
    public String code9; // 9-digit check-in code

    public Attendee(String id, String firstName, String lastName, String email, String eventId, String code9){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.eventId = eventId;
        this.code9 = code9;
    }

    public String getId() {return id; }
    public String getFirstName() {return firstName; }
    public String getLastName() {return lastName; }
    public String getEmail() {return email; }
    public String getEventId() {return eventId; }
    public String getCode9() {return code9; }
}
package com.joinup.model;

import java.util.Objects;

public class Attendee {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String eventId;
    private String phone;

    public Attendee() {}

    public Attendee(String id, String firstName, String lastName,
                    String email, String eventId, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.eventId = eventId;
        this.phone = phone;
    }

    // getters / setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEventId() { return eventId; }
    public void setEventId(String eventId) { this.eventId = eventId; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    // equality by id
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attendee)) return false;
        Attendee attendee = (Attendee) o;
        return Objects.equals(id, attendee.id);
    }
    @Override public int hashCode() { return Objects.hash(id); }
}

package com.joinup.service;
import com.joinup.model.Attendee;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    private final IAttendeeService attendees;

    public AttendanceService(IAttendeeService attendees) {
        this.attendees = attendees;
    }

    public Attendee registerAttendance(String attendeeName) {
        validateAttendee(attendeeName);

        Attendee a = new Attendee();
        a.setFirstName(attendeeName);
        attendees.registerAttendee(a);

        return a;
    }

    private void validateAttendee(String attendeeName) {
        if (attendeeName == null || attendeeName.isEmpty()) {
            throw new IllegalArgumentException("Attendee name cannot be null or empty");
        }
    }
}

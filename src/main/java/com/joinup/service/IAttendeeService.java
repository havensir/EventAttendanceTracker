package com.joinup.service;

import com.joinup.model.Attendee;

import java.util.List;

public interface IAttendeeService {
    List<Attendee> listAttendees();
    Attendee registerAttendee(Attendee attendee);
}

package com.joinup.dao;

import com.joinup.model.Attendee;
import java.util.List;

public interface IAttendeeDao {
    List<Attendee> getAllAttendees();
    Attendee getAttendeeById(int id);
    void registerAttendee(Attendee attendee);
}
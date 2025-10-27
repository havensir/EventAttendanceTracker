package com.joinup.dao;

import java.util.List;
import com.joinup.model.Event;

public interface IEventDao {
    List<Event> getAllEvents();
    Event getEventById(int id);
    void addEvent(Event event);
}
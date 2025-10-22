package com.joinup.service;

import com.joinup.model.Event;
import java.util.List;

public interface IEventService {
    List<Event> listEvents();
    Event getEventDetails(int id);
    void createEvent(Event event);
}
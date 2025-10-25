package com.joinup.service;

import com.joinup.model.Event;
import java.util.List;

public interface IEventService {
    List<Event> listEvents();
    Event createEvent(Event event);

    Event getEventById(String id);
}

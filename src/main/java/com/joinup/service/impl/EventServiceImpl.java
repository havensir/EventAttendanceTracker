package com.joinup.service.impl;

import com.joinup.model.Event;
import com.joinup.service.IEventService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EventServiceImpl implements IEventService {

    private final Map<String, Event> events = new ConcurrentHashMap<>();

    @Override
    public List<Event> listEvents() {
        return new ArrayList<>(events.values());
    }

    @Override
    public Event createEvent(Event event) {
        if (event.getId() == null || event.getId().isBlank()) {
            event.setId("E-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        events.put(event.getId(), event);
        return event;
    }

    @Override
    public Event getEventById(String id) {
        return events.get(id);
    }

    // convenience for seeder/tests
    public boolean isEmpty() {
        return events.isEmpty();
    }
}

package com.joinup.controller;

import com.joinup.model.Event;
import com.joinup.service.IEventService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Milestone 1: simple REST controller backed by service layer (no MockData). */
@RestController
@RequestMapping(path = "/api/events", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventController {

    private final IEventService eventService;

    public EventController(IEventService eventService) {
        this.eventService = eventService;
    }

    /** GET /api/events — list all */
    @GetMapping
    public List<Event> list() {
        return eventService.listEvents();
    }

    /** POST /api/events — create one (optional but handy for testing) */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Event create(@RequestBody Event event) {
        return eventService.createEvent(event);
    }
}

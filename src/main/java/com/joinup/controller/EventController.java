package com.joinup.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    // TODO: connect to IEventService once it's implemented
    @GetMapping
    public ResponseEntity<String> listEvents() {
        return ResponseEntity.status(501).body("TODO: List all events");
    }

    @PostMapping
    public ResponseEntity<String> createEvent() {
        return ResponseEntity.status(501).body("TODO: Create a new event");
    }
}

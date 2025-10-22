package com.joinup.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    // TODO: connect to IEventService once it's implemented

    @GetMapping(produces = "application/json")
    public ResponseEntity<String> listEvents() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body("{\"status\":\"TODO\",\"message\":\"List all events (M2 will implement)\",\"data\":[]}");
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createEvent() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body("{\"status\":\"TODO\",\"message\":\"Create a new event (M2 will implement)\"}");
    }
}

package com.joinup.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AttendeeController {

    // TODO: connect to IAttendeeService once it's implemented

    // Milestone-1 browser/fetch smoke-test: allow GET on /api/attendees
    @GetMapping(value = "/attendees", produces = "application/json")
    public ResponseEntity<String> listAllAttendees() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body("{\"status\":\"TODO\",\"message\":\"List all attendees (M2 will implement)\",\"data\":[]}");
    }

    // Existing GET (by event) still works at /api/events/{eventId}/attendees
    @GetMapping(value = "/events/{eventId}/attendees", produces = "application/json")
    public ResponseEntity<String> listAttendees(@PathVariable String eventId) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body("{\"status\":\"TODO\",\"message\":\"List attendees for event " + eventId + " (M2 will implement)\",\"data\":[]}");
    }

    @PostMapping(value = "/attendees", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> registerAttendee() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body("{\"status\":\"TODO\",\"message\":\"Register a new attendee (M2 will implement)\"}");
    }
}

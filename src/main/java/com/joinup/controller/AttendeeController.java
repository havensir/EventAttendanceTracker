package com.joinup.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AttendeeController {

    // TODO: connect to IAttendeeService once it's implemented
    @GetMapping("/events/{eventId}/attendees")
    public ResponseEntity<String> listAttendees(@PathVariable String eventId) {
        return ResponseEntity.status(501).body("TODO: List attendees for event " + eventId);
    }

    @PostMapping("/attendees")
    public ResponseEntity<String> registerAttendee() {
        return ResponseEntity.status(501).body("TODO: Register a new attendee");
    }
}
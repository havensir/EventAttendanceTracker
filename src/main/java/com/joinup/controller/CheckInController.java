package com.joinup.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CheckInController {

    // TODO: connect to ICheckInService once it's implemented
    @PostMapping("/checkins")
    public ResponseEntity<String> checkIn() {
        return ResponseEntity.status(501).body("TODO: Check in an attendee");
    }

    @GetMapping("/events/{eventId}/stats")
    public ResponseEntity<String> getEventStats(@PathVariable String eventId) {
        return ResponseEntity.status(501).body("TODO: Get stats for event " + eventId);
    }
}
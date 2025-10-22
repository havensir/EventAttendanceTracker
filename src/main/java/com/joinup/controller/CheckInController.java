package com.joinup.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CheckInController {

    // TODO: connect to ICheckInService once it's implemented

    // Milestone-1 browser/fetch smoke-test: allow GET on /api/checkins
    @GetMapping(value = "/checkins", produces = "application/json")
    public ResponseEntity<String> listCheckins() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body("{\"status\":\"TODO\",\"message\":\"List all check-ins (M2 will implement)\",\"data\":[]}");
    }

    @PostMapping(value = "/checkins", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> checkIn() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body("{\"status\":\"TODO\",\"message\":\"Check in an attendee (M2 will implement)\"}");
    }

    @GetMapping(value = "/events/{eventId}/stats", produces = "application/json")
    public ResponseEntity<String> getEventStats(@PathVariable String eventId) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body("{\"status\":\"TODO\",\"message\":\"Get stats for event " + eventId + " (M2 will implement)\"}");
    }
}

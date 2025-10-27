package com.joinup.controller;

import com.joinup.model.Attendee;
import com.joinup.service.IAttendeeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Milestone 1: Attendees endpoint backed by service layer. */
@RestController
@RequestMapping(path = "/api/attendees", produces = MediaType.APPLICATION_JSON_VALUE)
public class AttendeeController {

    private final IAttendeeService attendeeService;

    public AttendeeController(IAttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    /** GET /api/attendees — list all */
    @GetMapping
    public List<Attendee> list() {
        return attendeeService.listAttendees();
    }

    /** POST /api/attendees — register one (optional) */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Attendee register(@RequestBody Attendee attendee) {
        return attendeeService.registerAttendee(attendee);
    }
}

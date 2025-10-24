package com.joinup.controller;

import com.joinup.mock.MockData;
import com.joinup.model.Attendee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Milestone 1: simple GET that returns mock attendees. */
@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {
    @GetMapping
    public List<Attendee> list() {
        return MockData.attendees();
    }
}

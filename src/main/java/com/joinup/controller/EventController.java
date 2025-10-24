package com.joinup.controller;

import com.joinup.mock.MockData;
import com.joinup.model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Milestone 1: simple GET that returns mock events. */
@RestController
@RequestMapping("/api/events")
public class EventController {
    @GetMapping
    public List<Event> list() {
        return MockData.events();
    }
}

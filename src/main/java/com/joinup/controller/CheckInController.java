package com.joinup.controller;

import com.joinup.mock.MockData;
import com.joinup.model.CheckIn;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Milestone 1: simple GET that returns mock check-ins. */
@RestController
@RequestMapping("/api/checkins")
public class CheckInController {
    @GetMapping
    public List<CheckIn> list() {
        return MockData.checkIns();
    }
}

package com.joinup.controller;

import com.joinup.model.CheckIn;
import com.joinup.service.ICheckInService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Milestone 1: Check-ins endpoint backed by service layer. */
@RestController
@RequestMapping(path = "/api/checkins", produces = MediaType.APPLICATION_JSON_VALUE)
public class CheckInController {

    private final ICheckInService checkInService;

    public CheckInController(ICheckInService checkInService) {
        this.checkInService = checkInService;
    }

    /** GET /api/checkins — list all */
    @GetMapping
    public List<CheckIn> list() {
        return checkInService.listCheckIns();
    }

    /**
     * POST /api/checkins — create a check-in.
     * If your domain prefers attendeeId/eventId, expose a DTO and call checkInService.checkIn(attId, evtId).
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CheckIn create(@RequestBody CheckIn checkIn) {
        return checkInService.create(checkIn);
    }
}

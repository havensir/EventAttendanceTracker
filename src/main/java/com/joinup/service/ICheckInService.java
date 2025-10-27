package com.joinup.service;

import com.joinup.model.CheckIn;

import java.util.List;

public interface ICheckInService {
    List<CheckIn> listCheckIns();

    /**
     * Domain-friendly path (preferred long-term):
     * Create a check-in from attendeeId + eventId and return the resulting record.
     */
    CheckIn checkIn(String attendeeId, String eventId);

    /**
     * Utility for Milestone 1 seeding/testing: allow direct creation from a CheckIn object.
     */
    CheckIn create(CheckIn checkIn);
}

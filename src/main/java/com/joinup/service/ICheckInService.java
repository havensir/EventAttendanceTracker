package com.joinup.service;

import com.joinup.model.CheckIn;
import java.util.List;

public interface ICheckInService {
    void checkIn(int eventId, int attendeeId);
    List<CheckIn> getStats(int eventId);
}
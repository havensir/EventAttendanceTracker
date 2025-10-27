package com.joinup.dao;

import com.joinup.model.CheckIn;
import java.util.List;

public interface ICheckInDao {
    void addCheckIn(CheckIn checkIn);
    List<CheckIn> getCheckInsByEvent(int eventId);
}

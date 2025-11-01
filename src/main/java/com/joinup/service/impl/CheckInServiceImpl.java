package com.joinup.service.impl;

import com.joinup.model.CheckIn;
import com.joinup.service.ICheckInService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CheckInServiceImpl implements ICheckInService {

    private final Map<String, CheckIn> checkIns = new ConcurrentHashMap<>();

    @Override
    public List<CheckIn> listCheckIns() {
        return new ArrayList<>(checkIns.values());
    }

    @Override
    public CheckIn checkIn(String attendeeId, String eventId) {
        CheckIn ci = new CheckIn(
                "CI-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase(),
                attendeeId,
                eventId,
                OffsetDateTime.now().toString(),
                "success"
        );
        checkIns.put(ci.getCheckInId(), ci);
        return ci;
    }

    @Override
    public CheckIn create(CheckIn checkIn) {
        if (checkIn.getCheckInId() == null || checkIn.getCheckInId().isBlank()) {
            checkIn.setCheckInId("CI-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        if (checkIn.getTimestamp() == null || checkIn.getTimestamp().isBlank()) {
            checkIn.setTimestamp(OffsetDateTime.now().toString());
        }
        if (checkIn.getStatusValue() == null || checkIn.getStatusValue().isBlank()) {
            checkIn.setStatus("success");
        }
        checkIns.put(checkIn.getCheckInId(), checkIn);
        return checkIn;
    }

    // convenience for seeder/tests
    public boolean isEmpty() {
        return checkIns.isEmpty();
    }
}

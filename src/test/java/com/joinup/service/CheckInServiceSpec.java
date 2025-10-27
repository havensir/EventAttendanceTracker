package com.joinup.service;

import com.joinup.config.TestFixtures;
import com.joinup.model.CheckIn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckInServiceSpec {

    @Test
    @DisplayName("Given mocked check-ins when listing then statuses are present")
    void listCheckIns_hasStatus(){
        List<CheckIn> rows = TestFixtures.sampleCheckIns();
        assertFalse(rows.isEmpty());
        assertEquals("success", rows.get(0).getStatus());
    }
}

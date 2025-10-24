package com.joinup.service;

import com.joinup.config.TestFixtures;
import com.joinup.model.Attendee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttendeeServiceSpec {

    @Test
    @DisplayName("Given mocked attendees when listing then at least one attendee exists")
    void listAttendees_hasRows(){
        List<Attendee> rows = TestFixtures.sampleAttendees();
        assertTrue(rows.size() >= 1, "should have at least one attendee");
        assertEquals("Ava", rows.get(0).getFirstName());
    }
}

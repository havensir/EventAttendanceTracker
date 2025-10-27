package com.joinup.service;

import com.joinup.config.TestFixtures;
import com.joinup.model.Event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventServiceSpec {

    @Test
    @DisplayName("Given mocked events when listing then first event has a name and id")
    void listEvents_basicShape(){
        List<Event> rows = TestFixtures.sampleEvents();
        Event first = rows.get(0);
        assertNotNull(first);
        assertEquals("E-001", first.getId());
        assertEquals("Welcome Mixer", first.getName());
    }
}

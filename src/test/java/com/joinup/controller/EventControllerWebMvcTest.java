package com.joinup.controller;

import com.joinup.service.IEventService;
import com.joinup.config.TestFixtures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EventController.class)
class EventControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IEventService eventService;

    @Test
    @DisplayName("GET /api/events returns 200 with JSON array of events")
    void getEvents_ok() throws Exception {
        when(eventService.listEvents()).thenReturn(TestFixtures.sampleEvents());

        mvc.perform(get("/api/events"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$[0].id").value("E-001"))
            .andExpect(jsonPath("$[0].name").value("Welcome Mixer"))
            .andExpect(jsonPath("$[1].location").value("Scioto Hall 9F Lounge"));
    }
}

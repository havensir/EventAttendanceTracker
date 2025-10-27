package com.joinup.controller;

import com.joinup.service.IAttendeeService;
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

@WebMvcTest(AttendeeController.class)
class AttendeeControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IAttendeeService attendeeService;

    @Test
    @DisplayName("GET /api/attendees returns 200 with JSON array of attendees")
    void getAttendees_ok() throws Exception {
        when(attendeeService.listAttendees()).thenReturn(TestFixtures.sampleAttendees());

        mvc.perform(get("/api/attendees"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$[0].firstName").value("Ava"))
            .andExpect(jsonPath("$[1].email").value("juwan@example.com"));
    }
}

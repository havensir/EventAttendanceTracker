package com.joinup.controller;

import com.joinup.service.ICheckInService;
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

@WebMvcTest(CheckInController.class)
class CheckInControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ICheckInService checkInService;

    @Test
    @DisplayName("GET /api/checkins returns 200 with JSON array of check-ins")
    void getCheckIns_ok() throws Exception {
        when(checkInService.listCheckIns()).thenReturn(TestFixtures.sampleCheckIns());

        mvc.perform(get("/api/checkins"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$[0].status").value("success"))
            .andExpect(jsonPath("$[1].attendeeId").value("A-102"));
    }
}

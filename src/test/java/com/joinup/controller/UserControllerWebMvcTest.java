package com.joinup.controller;

import com.joinup.model.Role;
import com.joinup.model.User;
import com.joinup.service.IUserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@Import(UserControllerWebMvcTest.DisableInterceptorsConfig.class)
class UserControllerWebMvcTest {

    @Autowired private MockMvc mvc;
    @MockBean private IUserService service;

    @Test
    void listUsers_ok() throws Exception {
        Mockito.when(service.getAll()).thenReturn(List.of(
                new User(1L, "Test", "Alpha", "Co", "a@x.com", "111", Role.USER),
                new User(2L, "Beta", "Bravo", "Co", "b@x.com", "222", Role.ADMIN)
        ));

        mvc.perform(get("/api/users").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].firstName").value("Test"))
           .andExpect(jsonPath("$[0].lastName").value("Alpha"))
           .andExpect(jsonPath("$[0].role").value("USER"))
           .andExpect(jsonPath("$[1].email").value("b@x.com"));
    }

    /** Prevent test from being redirected by any app-wide interceptors (login, etc.) */
    @Configuration
    static class DisableInterceptorsConfig implements WebMvcConfigurer {
        @Override public void addInterceptors(InterceptorRegistry registry) {
            // no-op: don't register app interceptors in this slice test
        }
    }
}

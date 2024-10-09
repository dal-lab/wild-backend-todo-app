package com.example.demo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.example.demo.application.TaskFinder;
import com.example.demo.infrastructure.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetTaskController.class)
class GetTaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskFinder taskFinder;

    @BeforeEach
    void setUp() {
        given(taskFinder.getTask(1L)).willReturn(new Task(1L, "오늘 할 일"));
    }

    @Test
    void shouldReturnTaskById() throws Exception {
        String json = "{\"id\":1,\"content\":\"오늘 할 일\"}";
        mockMvc.perform(get("/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString(json)
                ));
    }
}

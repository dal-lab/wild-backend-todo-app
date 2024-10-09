package com.example.demo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.application.TaskUpdater;
import com.example.demo.infrastructure.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UpdateTaskController.class)
class UpdateTaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskUpdater taskUpdater;

    @Test
    void shouldReturnUpdatedTask() throws Exception {
        String requestData = "{\"content\":\"내일 할 일\"}";

        String json = "{\"id\":1,\"content\":\"내일 할 일\"}";

        given(taskUpdater.updateTask(1L, "내일 할 일")).willReturn(
                new Task(1L, "내일 할 일"));

        mockMvc.perform(patch("/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestData)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString(json)
                ));
    }
}

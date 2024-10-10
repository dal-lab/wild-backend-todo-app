package com.example.demo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.application.TaskRemover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RemoveTaskController.class)
class RemoveTaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskRemover taskRemover;

    private static final Long EXISTING_TASK_ID = 1L;
    private static final Long NON_EXISTING_TASK_ID = 9999L;

    @BeforeEach
    void setUp() {
        given(taskRemover.removeTask(EXISTING_TASK_ID)).willReturn(true);
        given(taskRemover.removeTask(NON_EXISTING_TASK_ID)).willReturn(false);
    }

    @Test
    void shouldReturnSuccessWhenTaskDeleted() throws Exception {
        mockMvc.perform(delete("/tasks/" + EXISTING_TASK_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("success")));
    }

    @Test
    void shouldReturnFailWhenTaskNotDeleted() throws Exception {
        mockMvc.perform(delete("/tasks/" + NON_EXISTING_TASK_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("fail")));
    }
}

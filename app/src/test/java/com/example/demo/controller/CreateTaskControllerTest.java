package com.example.demo.controller;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.application.TaskCreator;
import com.example.demo.controller.dto.CreateTaskRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CreateTaskController.class)
class CreateTaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskCreator taskCreator;

    @Test
    void shouldReturnNoContent() throws Exception {
        String mockJson = "{\n"
                + "    \"content\": \"오늘 할 일\"\n"
                + "}";

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mockJson)
                )
                .andExpect(status().isCreated());

        String mockContent = "오늘 할 일";
        verify(taskCreator).createTask(mockContent);
    }
}

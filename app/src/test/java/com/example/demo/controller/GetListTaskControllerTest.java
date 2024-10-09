package com.example.demo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetListTaskController.class)
class GetListTaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnTaskList() throws Exception {
        String json = "{\"tasks\":[{\"id\":1,\"content\":\"오늘 할 일\"}]}";

        mockMvc.perform(get("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                )
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString(json)));
    }
}

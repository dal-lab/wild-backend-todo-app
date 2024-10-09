package com.example.demo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.application.TaskGetters;
import com.example.demo.infrastructure.Task;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetListTaskController.class)
class GetListTaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskGetters taskGetters;

    @BeforeEach
    void setUp() {
        List<Task> mockTasks = Arrays.asList(
                new Task(1L, "오늘 할 일"),
                new Task(2L, "내일 할 일")
        );

        given(taskGetters.getListTask()).willReturn(mockTasks);
    }

    @Test
    void shouldReturnTaskList() throws Exception {
        String json = "{\"tasks\":[{\"id\":1,\"content\":\"오늘 할 일\"},{\"id\":2,\"content\":\"내일 할 일\"}]}";

        mockMvc.perform(get("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                )
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString(json)));
    }
}

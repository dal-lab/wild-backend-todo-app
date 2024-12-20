package com.example.demo.presentation;

import com.example.demo.application.TaskCreator;
import com.example.demo.infrastructure.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {
    // MockBean 이랑 SpyBean 은 deprecated 되었는데 어떻게 해야되나?
    //

    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private TaskCreator taskCreator;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    void list() throws Exception {
        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        String json = """
                {
                    "taskName": "test1",
                    "taskDescription": "test123"
                }
                """;


        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(content().string(
                        containsString("taskName")
                ));

        verify(taskRepository).add(any());
    }


}

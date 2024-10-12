package com.example.demo;

import com.example.demo.presentation.TodoController;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private int todoId;

    @BeforeEach
    void setup() throws Exception {
        // 새로운 Todo를 생성하고, 그 ID를 저장
        String newTodo = "{ \"title\": \"Initial Todo\" }";
        MvcResult result = mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newTodo))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Initial Todo"))
                .andReturn();
        // JSON 응답에서 ID 값을 추출하여 저장
        String responseContent = result.getResponse().getContentAsString();
        todoId = JsonPath.read(responseContent, "$.id");
    }

    @Test
    void list() throws Exception {
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"title\":\"Initial Todo\",\"isCompleted\":false}]"));
    }

    @Test
    void create() throws Exception {
        String newTodo = "{ \"title\": \"New Todo\" }";
        mockMvc.perform(post("/todos")
                        .contentType("application/json")
                        .content(newTodo))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("New Todo"));
    }

    @Test
    void edit() throws Exception {
        String updatedTodo = "{ \"title\": \"Updated Todo\" }";
        mockMvc.perform(put("/todos/" + todoId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedTodo))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Updated Todo"));
    }

    @Test
    void deleteTodo() throws Exception {
        mockMvc.perform(delete("/todos/" + todoId))
                .andExpect(status().isNoContent());
    }

    @AfterEach
    void deleteAllTodo() throws Exception {
        mockMvc.perform(delete("/todos"))
                .andExpect(status().isNoContent());
    }

}

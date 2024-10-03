package com.example.demo.controller;

import com.example.demo.application.TaskCreator;
import com.example.demo.controller.dto.CreateTaskRequestDto;
import com.example.demo.controller.dto.CreateTaskResponseDto;
import com.example.demo.infrastructure.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class CreateTaskResource {

    private final TaskCreator taskCreator = new TaskCreator();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String handler(String content) throws IOException {
        CreateTaskRequestDto createTaskRequestDto = objectMapper.readValue(
                content,
                CreateTaskRequestDto.class
        );

        Task tasks = taskCreator.createTask(createTaskRequestDto.content());

        return objectMapper.writeValueAsString(
                new CreateTaskResponseDto(tasks.getContent())
        );
    }
}

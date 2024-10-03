package com.example.demo.controller;

import com.example.demo.application.TaskUpdator;
import com.example.demo.controller.dto.UpdateTaskRequestDto;
import com.example.demo.controller.dto.UpdateTaskResponseDto;
import com.example.demo.infrastructure.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class UpdateTaskResource {

    private final TaskUpdator taskUpdator = new TaskUpdator();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String handler(long id, String content) throws IOException {

        UpdateTaskRequestDto updateTaskRequestDto = objectMapper.readValue(
                content,
                UpdateTaskRequestDto.class
        );

        Task task = taskUpdator.updateTask(id, updateTaskRequestDto.content());

        return objectMapper.writeValueAsString(
                new UpdateTaskResponseDto(task.getContent())
        );
    }
}

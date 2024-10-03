package com.example.demo.controller;

import com.example.demo.application.TaskFinder;
import com.example.demo.controller.dto.FindTaskResponseDto;
import com.example.demo.infrastructure.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class FindTaskResource {

    private final TaskFinder taskFinder = new TaskFinder();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String handler(Long id) throws IOException {
        Task task = taskFinder.getTask(id);

        return objectMapper.writeValueAsString(
                new FindTaskResponseDto(
                        task.getId(),
                        task.getContents()
                )
        );
    }
}

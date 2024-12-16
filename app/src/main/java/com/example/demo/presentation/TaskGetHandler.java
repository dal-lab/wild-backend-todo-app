package com.example.demo.presentation;

import com.example.demo.application.TaskCreator;
import com.example.demo.dto.TaskRequestDto;
import com.example.demo.dto.TaskResponseDto;
import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class TaskGetHandler extends ResourceMethodHandler {
    public static final String KEY = "GET /tasks";

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final TaskCreator taskCreator = new TaskCreator();


    @Override
    public String handle(String content) throws JsonProcessingException {

        List<Task> tasks = taskCreator.getTasks();

        return objectMapper.writeValueAsString(
                tasks.stream()
                        .map(task -> new TaskResponseDto(
                                task.getTaskName(),
                                task.getTaskDescription()
                        ))
                        .toList()
        );
    }
}

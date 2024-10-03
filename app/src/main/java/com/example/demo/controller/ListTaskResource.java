package com.example.demo.controller;

import com.example.demo.RequestMethodHandler;
import com.example.demo.application.TaskGetters;
import com.example.demo.controller.dto.ListTaskResponseDto;
import com.example.demo.infrastructure.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class ListTaskResource implements RequestMethodHandler {

    public final static String KEY = "GET /tasks";

    private final TaskGetters taskGetters = new TaskGetters();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String handler(String content) throws JsonProcessingException {
        List<Task> taskList = taskGetters.getTaskList();

        return objectMapper.writeValueAsString(
                ListTaskResponseDto.of(taskList)
        );
    }
}

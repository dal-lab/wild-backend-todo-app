package com.example.demo.controller;

import com.example.demo.application.TaskFinder;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FindTaskResource {
    private final TaskFinder taskFinder = new TaskFinder();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String handler(Long id) {
        return taskFinder.getTask(id);
    }
}

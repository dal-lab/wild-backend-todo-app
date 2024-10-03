package com.example.demo.controller;

import com.example.demo.application.TaskRemover;

public class RemoveTaskResource {

    private final TaskRemover taskRemover = new TaskRemover();

    public String handler(Long id) {
        taskRemover.removeTask(id);

        return "success";
    }
}

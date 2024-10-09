package com.example.demo.controller;

import com.example.demo.application.TaskRemover;

public class RemoveTaskResource {

    public RemoveTaskResource(TaskRemover taskRemover) {
        this.taskRemover = taskRemover;
    }

    private final TaskRemover taskRemover;

    public String handler(Long id) {
        return taskRemover.removeTask(id) ? "success" : "fail";
    }
}

package com.example.demo.infrastructure;

import org.springframework.stereotype.Component;

public class Task {

    private String taskName;
    private String taskDescription;

    public Task(String taskName, String taskDescription) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    
    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskName() {
        return taskName;
    }
}

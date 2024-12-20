package com.example.demo.dto;

public class TaskResponseDto {

    private final String taskName;
    private final String taskDescription;

    public TaskResponseDto(String taskName, String taskDescription) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }
}

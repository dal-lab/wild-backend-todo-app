package com.example.demo.dto;


import com.example.demo.infrastructure.Task;

import java.util.List;

public class TaskListResponseDto {

    private final List<TaskResponseDto> tasks;

    public TaskListResponseDto(List<TaskResponseDto> tasks) {
        this.tasks = tasks;
    }

    public static TaskListResponseDto of(List<Task> tasks) {
        return new TaskListResponseDto(tasks.stream().map(
                task
                        -> new TaskResponseDto(
                        task.getTaskName(),
                        task.getTaskDescription())).toList(
        ));
    }

    public List<TaskResponseDto> getTasks() {
        return tasks;
    }
}

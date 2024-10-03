package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;

public class TaskCreator {

    TaskRepository taskRepository = new TaskRepository();

    public Task createTask(String content) {
        return taskRepository.save(content);
    }
}

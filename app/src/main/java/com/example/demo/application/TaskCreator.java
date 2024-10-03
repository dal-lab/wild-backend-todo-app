package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import com.example.demo.infrastructure.TaskRepositoryImp;

public class TaskCreator {

    private final TaskRepository taskRepository = TaskRepositoryImp.getInstance();

    public Task createTask(String content) {
        Task task = Task.createTask(content);

        taskRepository.save(task);
        return task;
    }
}

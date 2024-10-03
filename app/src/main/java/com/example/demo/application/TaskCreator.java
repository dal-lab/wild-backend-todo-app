package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import com.example.demo.infrastructure.TaskRepositoryImp;

public class TaskCreator {

    TaskRepository taskRepository = new TaskRepositoryImp();

    public Task createTask(String content) {
        return taskRepository.save(content);
    }
}

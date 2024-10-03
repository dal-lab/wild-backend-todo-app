package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import com.example.demo.infrastructure.TaskRepositoryImp;

public class TaskFinder {

    private final TaskRepository taskRepository = TaskRepositoryImp.getInstance();

    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new Error());
    }
}

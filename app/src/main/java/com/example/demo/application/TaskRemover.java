package com.example.demo.application;

import com.example.demo.infrastructure.TaskRepository;
import com.example.demo.infrastructure.TaskRepositoryImp;

public class TaskRemover {

    private final TaskRepository taskRepository = TaskRepositoryImp.getInstance();

    public void removeTask(Long id) {
        taskRepository.remove(id);
    }
}

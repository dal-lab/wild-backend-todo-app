package com.example.demo.application;

import com.example.demo.infrastructure.TaskRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskRemover {

    public TaskRemover(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private final TaskRepository taskRepository;

    public boolean removeTask(Long id) {
        return taskRepository.remove(id);
    }
}

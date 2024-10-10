package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskCreator {

    private final TaskRepository taskRepository;

    public TaskCreator(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(final String content) {
        taskRepository.save(Task.createTask(content));
    }
}

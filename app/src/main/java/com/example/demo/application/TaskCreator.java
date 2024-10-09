package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskCreator {

    private final TaskRepository taskRepository;

    public TaskCreator(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String content) {
        Task task = Task.createTask(content);

        taskRepository.save(task);
        return task;
    }
}

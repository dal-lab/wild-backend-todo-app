package com.example.demo.application;

import com.example.demo.exception.TaskIdNotFoundException;
import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskUpdater {

    private final TaskRepository taskRepository;

    public TaskUpdater(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task updateTask(Long id, String content) {
        Task task = taskRepository.findById(id)
                .orElseThrow(
                        () -> new TaskIdNotFoundException(id));

        task.updateTask(content);

        return task;
    }
}

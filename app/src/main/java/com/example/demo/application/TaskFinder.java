package com.example.demo.application;

import com.example.demo.exception.TaskIdNotFoundException;
import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskFinder {

    private final TaskRepository taskRepository;

    public TaskFinder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id)
            .orElseThrow(() -> new TaskIdNotFoundException(id));
    }

}

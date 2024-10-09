package com.example.demo.application;

import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskFinder {

    private final TaskRepository taskRepository;

    public TaskFinder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(
                        () -> new TaskNotFoundException("해당 task를 찾을 수 없습니다."));
    }
}

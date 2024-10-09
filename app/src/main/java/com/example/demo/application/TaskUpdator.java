package com.example.demo.application;

import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskUpdator {

    public TaskUpdator(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private final TaskRepository taskRepository;

    public Task updateTask(long id, String content) {
        Task task = taskRepository.findById(id)
                .orElseThrow(
                        () -> new TaskNotFoundException("해당 task를 찾을 수 없습니다.")
                );
        task.setContent(content);

        return task;
    }
}

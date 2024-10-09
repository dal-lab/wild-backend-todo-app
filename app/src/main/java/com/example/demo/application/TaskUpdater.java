package com.example.demo.application;

import com.example.demo.exception.TaskNotFoundException;
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
                        () -> new TaskNotFoundException("해당 Task를 찾을 수 없습니다."));

        task.updateTask(content);

        taskRepository.save(task);

        return task;
    }
}

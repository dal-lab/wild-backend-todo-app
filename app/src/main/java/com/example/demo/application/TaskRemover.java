package com.example.demo.application;

import com.example.demo.exception.TaskIdNotFoundException;
import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskRemover {

    private final TaskRepository taskRepository;

    public TaskRemover(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public boolean removeTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new TaskIdNotFoundException(taskId));

        return taskRepository.remove(task.getId()) ? true : false;
    }
}

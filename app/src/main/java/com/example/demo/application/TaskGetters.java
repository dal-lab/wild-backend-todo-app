package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TaskGetters {

    public TaskGetters(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private final TaskRepository taskRepository;

    public List<Task> getTaskList() {
        return taskRepository.findAll();
    }
}

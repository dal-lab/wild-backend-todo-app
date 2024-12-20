package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TaskCreator {
    private final TaskRepository taskRepository;

    public TaskCreator(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task create(String taskName, String taskDescription) {
        Task task = new Task(taskName, taskDescription);

        taskRepository.add(task);

        return task;
    }

    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }
}

package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;

import java.util.List;



public class TaskCreator {

    private final TaskRepository taskRepository
            = TaskRepository.getInstance();

    public Task create(String taskName, String taskDescription) {
        Task task = new Task(taskName, taskDescription);

        taskRepository.add(task);

        return task;
    }

    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }
}

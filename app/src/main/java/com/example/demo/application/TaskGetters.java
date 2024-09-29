package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import com.example.demo.infrastructure.TaskRepositoryImp;
import java.util.List;

public class TaskGetters {

    private final TaskRepository taskRepository = TaskRepositoryImp.getInstance();

    public List<Task> getTaskList() {
        return taskRepository.findAll();
    }
}

package com.example.demo.application;

import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaskGetters {

    private final TaskRepository taskRepository;

    public TaskGetters(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getListTask() {
        List<Task> tasks = taskRepository.findAll();
        if (tasks.isEmpty()) {
            throw new TaskNotFoundException("해당 Task 정보를 찾을 수 없습니다.");
        }

        return tasks;
    }
}

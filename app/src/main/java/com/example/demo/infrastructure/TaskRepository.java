package com.example.demo.infrastructure;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    public void add(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}

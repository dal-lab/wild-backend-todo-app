package com.example.demo.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepositoryImp implements TaskRepository {

    List<Task> tasks = new ArrayList<>();
    private static TaskRepositoryImp instance = null;

    public static TaskRepositoryImp getInstance() {
        if (instance == null) {
            instance = new TaskRepositoryImp();
        }
        return instance;
    }

    @Override
    public void save(final Task task) {
        tasks.add(task);
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }

    @Override
    public void remove(Long id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}

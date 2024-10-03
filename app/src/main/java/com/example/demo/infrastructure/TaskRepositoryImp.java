package com.example.demo.infrastructure;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(tasks);
        return new ArrayList<>(tasks);
    }
}

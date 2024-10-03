package com.example.demo.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImp implements TaskRepository {

    List<Task> tasks = new ArrayList<>();

    @Override
    public void save(final Task task) {
        tasks.add(task);
    }
}

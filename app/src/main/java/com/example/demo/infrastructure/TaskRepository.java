package com.example.demo.infrastructure;

import java.util.List;

public interface TaskRepository {

    void save(Task task);

    List<Task> findAll();
}

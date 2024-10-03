package com.example.demo.infrastructure;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    void save(Task task);

    List<Task> findAll();

    Optional<Task> findById(Long id);
}

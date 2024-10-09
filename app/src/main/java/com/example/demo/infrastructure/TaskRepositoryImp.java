package com.example.demo.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;

@Component
public class TaskRepositoryImp implements TaskRepository {

    List<Task> tasks = new ArrayList<>();

    private final AtomicLong atomicLong = new AtomicLong(1);

    private long nextId() {
        return atomicLong.getAndIncrement();
    }

    @Override
    public void save(final Task task) {
        task.assignId(nextId());
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
    public boolean remove(Long id) {
        return tasks.removeIf(task -> task.getId() == id);
    }
}

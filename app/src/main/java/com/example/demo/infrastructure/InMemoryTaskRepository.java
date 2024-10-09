package com.example.demo.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;

@Component
public class InMemoryTaskRepository implements TaskRepository {

    List<Task> tasks = new ArrayList<>();

    private final AtomicLong atomicLong = new AtomicLong(1);

    @Override
    public void save(Task task) {
        task.assignId(nextId());
        tasks.add(task);
    }

    private long nextId() {
        return atomicLong.getAndIncrement();
    }
}

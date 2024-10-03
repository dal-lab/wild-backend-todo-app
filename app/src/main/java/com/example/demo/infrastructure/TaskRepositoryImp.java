package com.example.demo.infrastructure;

import java.util.concurrent.atomic.AtomicLong;

public class TaskRepositoryImp implements TaskRepository {

    private final AtomicLong atomicLong = new AtomicLong(1);

    @Override
    public Task save(final String content) {
        long id = Task.assignId(nextId());

        return Task.createTask(id, content);
    }

    private long nextId() {
        return atomicLong.getAndIncrement();
    }
}

package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import com.example.demo.infrastructure.TaskRepositoryImp;
import java.util.concurrent.atomic.AtomicLong;

public class TaskCreator {

    private final TaskRepository taskRepository = TaskRepositoryImp.getInstance();
    private final AtomicLong atomicLong = new AtomicLong(1);

    public Task createTask(String content) {
        long id = Task.assignId(nextId());
        Task task = Task.createTask(id, content);

        taskRepository.save(task);
        return task;
    }

    private long nextId() {
        return atomicLong.getAndIncrement();
    }
}

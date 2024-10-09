package com.example.demo.infrastructure;

public class Task {

    private Long id;

    private String content;

    public Task(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Task(String content) {
        this.content = content;
    }

    public void assignId(final long nextId) {
        this.id = nextId;
    }

    public static Task createTask(String content) {
        return new Task(content);
    }
}

package com.example.demo.infrastructure;

public class Task {

    private long id;
    private String contents;

    public Task(final long id, final String contents) {
        this.id = id;
        this.contents = contents;
    }

    public Task(final long id) {
        this.id = id;
    }

    protected Task() {
    }

    public Long getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public static Task createTask(final long id, final String content) {
        return new Task(id, content);
    }

    public static long assignId(final long nextId) {
        Task task = new Task(nextId);
        return task.id = nextId;
    }
}

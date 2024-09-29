package com.example.demo.infrastructure;

public class Task {

    private long id;
    private String content;

    public Task(final long id, final String content) {
        this.id = id;
        this.content = content;
    }

    protected Task() {
    }

    public Task(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public static Task createTask(final String content) {
        return new Task(content);
    }

    public void assignId(final long nextId) {
        this.id = nextId;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", contents='" + content + '\'' +
                '}';
    }
}

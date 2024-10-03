package com.example.demo.infrastructure;

public class Task {

    private long id;
    private String contents;

    public Task(final long id, final String contents) {
        this.id = id;
        this.contents = contents;
    }

    protected Task() {
    }

    public Task(String contents) {
        this.contents = contents;
    }

    public long getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public void setContent(final String content) {
        this.contents = content;
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
                ", contents='" + contents + '\'' +
                '}';
    }
}

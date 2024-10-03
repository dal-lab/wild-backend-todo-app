package com.example.demo.infrastructure;

public class Todo {
    private final int id;
    private final String title;
    private final boolean isCompleted;

    public Todo(int id, String title) {
        this.id = id;
        this.title = title;
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}

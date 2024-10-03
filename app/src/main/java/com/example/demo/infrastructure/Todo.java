package com.example.demo.infrastructure;

public class Todo {
    private final int id;
    private String title;
    private boolean isCompleted;

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

    public void setTitle(String s) {
        this.title = s;

    }

    public void setCompleted(Boolean aBoolean) {
        this.isCompleted = aBoolean;
    }
}

package com.example.demo.infrastructure;

public class Todo {
    private final int id;
    private String title;
    private boolean isCompleted;

    public Todo() {
        this.id = 0;
        this.title = "";
        this.isCompleted = false;
    }

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

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setTitle(String s) {
        this.title = s;

    }

    public void setCompleted(boolean aBoolean) {
        this.isCompleted = aBoolean;
    }
}

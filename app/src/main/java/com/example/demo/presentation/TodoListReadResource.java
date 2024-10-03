package com.example.demo.presentation;

public class TodoListReadResource extends ResourceMethodHandler{
    static final String KEY = "GET /todos";

    @Override
    public String handle(String content) {
        return "TodoListReadResource: " + content;
    }

    @Override
    public String getKey() {
        return KEY;
    }
}

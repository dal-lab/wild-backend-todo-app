package com.example.demo.presentation;

public class TodoCreateResource extends ResourceMethodHandler {
    static final String KEY = "POST /todos";

    @Override
    public String handle(String content) {
        return "TodoCreateResource" + content;
    }

    @Override
    public String getKey() {
        return KEY;
    }
}

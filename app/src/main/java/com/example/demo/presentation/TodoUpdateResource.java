package com.example.demo.presentation;

public class TodoUpdateResource extends ResourceMethodHandler {
    static final String KEY = "PUT /todos";

    @Override
    public String handle(String content) {
        return "TodoUpdateResource: " + content;
    }

    @Override
    public String getKey() {
        return KEY;
    }
}

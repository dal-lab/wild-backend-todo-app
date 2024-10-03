package com.example.demo.presentation;

public class TodoDeleteResource extends ResourceMethodHandler{
    static final String KEY = "DELETE /todos";
    @Override
    public String handle(String content) {
        return "TodoDeleteResource: " + content;
    }

    @Override
    public String getKey() {
        return KEY;
    }
}

package com.example.demo.presentation;

import org.springframework.stereotype.Component;

@Deprecated
@Component
public class DefaultHandler implements TodoItemsHandler {
    @Override
    public String getKey() {
        return "default";
    }

    @Override
    public String handle(String requestBody) {
        return "Hollo, World!";
    }
}

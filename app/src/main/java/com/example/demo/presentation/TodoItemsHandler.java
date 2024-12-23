package com.example.demo.presentation;

import com.sun.net.httpserver.HttpExchange;

@Deprecated
public interface TodoItemsHandler {
    String getKey();
    String handle(String requestBody);
}

package com.example.demo.controller;

import com.example.demo.RequestMethodHandler;

public class CreateTaskResource implements RequestMethodHandler {

    public final static String KEY = "POST /tasks";

    @Override
    public String handler(String content) {
        return content;
    }
}

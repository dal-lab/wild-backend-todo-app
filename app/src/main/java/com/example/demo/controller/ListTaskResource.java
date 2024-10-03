package com.example.demo.controller;

import com.example.demo.RequestMethodHandler;

public class ListTaskResource implements RequestMethodHandler {

    public final static String KEY = "GET /tasks";

    @Override
    public String handler(String content) {
        return "success";
    }
}

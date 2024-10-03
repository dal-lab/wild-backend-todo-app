package com.example.demo.controller;

import com.example.demo.RequestMethodHandler;

public class HomeResource implements RequestMethodHandler {

    public final static String KEY = "GET /";

    @Override
    public String handler(String content) {
        return "Hello World";
    }
}

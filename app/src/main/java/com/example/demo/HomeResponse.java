package com.example.demo;

public class HomeResponse implements RequestMethodHandler {

    public final static String KEY = "GET /";

    @Override
    public String handler(String content) {
        return "Hello World";
    }
}

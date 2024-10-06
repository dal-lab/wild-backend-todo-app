package com.example.demo;

public enum HttpStatus {
    OK(200, "Success"),
    CREATE(201, "Created"),
    NOT_FOUND(404, "Not Found");

    private int value;
    private String text;

    HttpStatus(int value, String text) {
        this.value = value;
        this.text = text;
    }

    int value() {
        return value;
    }

    @Override
    public String toString() {
        return "HttpStatus{" +
                "value=" + value +
                '}';
    }
}

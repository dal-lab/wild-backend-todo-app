package com.example.demo.http;

public class TaskPathId {

    public Long getPathId(String requestUri) {
        return Long.parseLong(requestUri.substring(getPathUri().length()));
    }

    public String getPathUri() {
        return "/tasks/";
    }
}

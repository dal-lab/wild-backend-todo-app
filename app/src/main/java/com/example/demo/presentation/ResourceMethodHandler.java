package com.example.demo.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class ResourceMethodHandler {
    public abstract String handle(String content, Integer paramId) throws JsonProcessingException;

    public abstract String getKey();

    public abstract int getStatusCode();
}

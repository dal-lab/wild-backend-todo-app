package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class FindTaskResource {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String handler(String requestPath, Long id) throws IOException {
        return "success";
    }
}

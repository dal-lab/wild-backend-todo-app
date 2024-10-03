package com.example.demo.controller.dto;

public class CreateTaskResponseDto {
    private String content;

    public CreateTaskResponseDto(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

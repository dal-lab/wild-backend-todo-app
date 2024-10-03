package com.example.demo.presentation.dto;

public record TodoUpdateRequestDto(int id, String title, boolean isCompleted) {
}

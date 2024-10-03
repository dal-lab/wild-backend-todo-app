package com.example.demo.controller.dto;

import com.example.demo.infrastructure.Task;
import java.util.List;
import java.util.stream.Collectors;

public record ListTaskResponseDto(
        List<ListTaskItemResponseDto> tasks
) {

    public static ListTaskResponseDto of(List<Task> tasks) {
        return new ListTaskResponseDto(
                tasks.stream()
                        .map(task -> new ListTaskItemResponseDto(
                                task.getId(),
                                task.getContent()
                        )).collect(Collectors.toList())
        );
    }
}

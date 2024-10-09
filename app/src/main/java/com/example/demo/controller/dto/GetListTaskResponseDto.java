package com.example.demo.controller.dto;

import com.example.demo.infrastructure.Task;
import java.util.List;
import java.util.stream.Collectors;

public record GetListTaskResponseDto(
        List<GetTaskItemResponseDto> tasks
) {

    public static GetListTaskResponseDto of(List<Task> tasks) {
        return new GetListTaskResponseDto(
                tasks.stream()
                        .map(item -> new GetTaskItemResponseDto(
                                item.getId(),
                                item.getContent()
                        )).collect(Collectors.toList())
        );
    }
}

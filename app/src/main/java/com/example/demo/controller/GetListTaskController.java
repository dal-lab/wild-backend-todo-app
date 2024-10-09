package com.example.demo.controller;

import com.example.demo.application.TaskGetters;
import com.example.demo.controller.dto.GetListTaskResponseDto;
import com.example.demo.infrastructure.Task;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class GetListTaskController {

    private TaskGetters taskGetters;

    @GetMapping
    public GetListTaskResponseDto getListTaskHandler() {
        return GetListTaskResponseDto.of(List.of(new Task(1L, "오늘 할 일")));
    }
}

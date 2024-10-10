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

    private final TaskGetters taskGetters;

    public GetListTaskController(TaskGetters taskGetters) {
        this.taskGetters = taskGetters;
    }

    @GetMapping
    public GetListTaskResponseDto getListTaskHandler() {
        List<Task> tasks = this.taskGetters.getListTask();

        return GetListTaskResponseDto.of(tasks);
    }
}

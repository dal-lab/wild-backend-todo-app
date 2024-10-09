package com.example.demo.controller;

import com.example.demo.application.TaskGetters;
import com.example.demo.controller.dto.ListTaskResponseDto;
import com.example.demo.infrastructure.Task;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class ListTaskController {

    private final TaskGetters taskGetters;

    public ListTaskController(TaskGetters taskGetters) {
        this.taskGetters = taskGetters;
    }

    @GetMapping
    public ListTaskResponseDto getTaskListHandler() {
        List<Task> taskList = taskGetters.getTaskList();

        return ListTaskResponseDto.of(taskList);
    }
}

package com.example.demo.controller;

import com.example.demo.application.TaskCreator;
import com.example.demo.controller.dto.CreateTaskRequestDto;
import com.example.demo.controller.dto.CreateTaskResponseDto;
import com.example.demo.infrastructure.Task;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class CreateTaskController {

    private final TaskCreator taskCreator;

    public CreateTaskController(TaskCreator taskCreator) {
        this.taskCreator = taskCreator;
    }

    @PostMapping
    public CreateTaskResponseDto handler(
            @RequestBody CreateTaskRequestDto createTaskRequestDto) {

        Task tasks = taskCreator.createTask(createTaskRequestDto.content());

        return new CreateTaskResponseDto(tasks.getContent());
    }
}

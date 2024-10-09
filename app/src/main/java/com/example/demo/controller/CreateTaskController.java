package com.example.demo.controller;

import com.example.demo.application.TaskCreator;
import com.example.demo.controller.dto.CreateTaskRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class CreateTaskController {

    private TaskCreator taskCreator;

    public CreateTaskController(TaskCreator taskCreator) {
        this.taskCreator = taskCreator;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createTaskHandler(@RequestBody CreateTaskRequestDto createTaskRequestDto) {
        String content = createTaskRequestDto.getContent();

        this.taskCreator.createTask(content);
    }
}

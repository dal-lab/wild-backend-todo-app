package com.example.demo.presentation;

import com.example.demo.application.TaskCreator;
import com.example.demo.dto.TaskListResponseDto;
import com.example.demo.dto.TaskRequestDto;
import com.example.demo.dto.TaskResponseDto;
import com.example.demo.infrastructure.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskCreator taskCreator;

    public TaskController(
            TaskCreator taskCreator
    ) {
        this.taskCreator = taskCreator;
    }

    @GetMapping
    public TaskListResponseDto list() {

        List<Task> tasks = taskCreator.getTasks();

        return TaskListResponseDto.of(tasks);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponseDto create(
            @RequestBody TaskRequestDto requestDto
    ) {

        Task task = taskCreator.create(
                requestDto.getTaskName(),
                requestDto.getTaskDescription()
        );


        return new TaskResponseDto(
                task.getTaskName(),
                task.getTaskDescription());

    }
}

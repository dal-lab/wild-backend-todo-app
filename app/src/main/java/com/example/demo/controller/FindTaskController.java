package com.example.demo.controller;

import com.example.demo.application.TaskFinder;
import com.example.demo.controller.dto.FindTaskResponseDto;
import com.example.demo.infrastructure.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class FindTaskController {

    private final TaskFinder taskFinder;

    public FindTaskController(TaskFinder taskFinder) {
        this.taskFinder = taskFinder;
    }

    @GetMapping("/{id}")
    public FindTaskResponseDto getTaskHandler(@PathVariable String id) {
        Task task = taskFinder.getTask(Long.valueOf(id));

        return new FindTaskResponseDto(
                task.getId(),
                task.getContent()
        );
    }
}

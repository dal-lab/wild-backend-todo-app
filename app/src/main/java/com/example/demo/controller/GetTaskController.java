package com.example.demo.controller;

import com.example.demo.application.TaskFinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class GetTaskController {

    private final TaskFinder taskFinder;

    public GetTaskController(TaskFinder taskFinder) {
        this.taskFinder = taskFinder;
    }

    @GetMapping("{id}")
    public String getTaskHandler(@PathVariable Long id) {
        String task = taskFinder.getTask(id);

        return task;
    }
}

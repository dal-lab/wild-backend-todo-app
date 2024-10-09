package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class RemoveTaskController {

    @DeleteMapping("{taskId}")
    public String removeTaskHandler(@PathVariable("taskId") Long taskId) {
        return "success";
    }
}

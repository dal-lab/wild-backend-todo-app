package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class GetTaskController {

    @GetMapping("{id}")
    public String getTaskHandler(@PathVariable Long id) {
        return "success";
    }
}

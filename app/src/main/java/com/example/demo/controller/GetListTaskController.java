package com.example.demo.controller;

import com.example.demo.application.TaskGetters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class GetListTaskController {

    private TaskGetters taskGetters;

    @GetMapping
    public String getListTaskHandler() {
        return "success";
    }
}

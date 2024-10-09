package com.example.demo.controller;

import com.example.demo.controller.dto.UpdateTaskRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class UpdateTaskController {

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateTaskHandler(@PathVariable("id") Long id,
            UpdateTaskRequestDto updateTaskRequestDto) {
        return "success";
    }
}

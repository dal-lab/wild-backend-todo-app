package com.example.demo.controller;

import com.example.demo.application.TaskRemover;
import com.example.demo.controller.dto.DeleteResponseDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class RemoveTaskController {

    private final TaskRemover taskRemover;

    public RemoveTaskController(TaskRemover taskRemover) {
        this.taskRemover = taskRemover;
    }

    @DeleteMapping("{taskId}")
    public DeleteResponseDto removeTaskHandler(
            @PathVariable("taskId") Long taskId) {

        return taskRemover.removeTask(taskId) ? new DeleteResponseDto("success")
                : new DeleteResponseDto("fail");
    }
}

package com.example.demo.controller;

import com.example.demo.application.TaskUpdater;
import com.example.demo.controller.dto.UpdateTaskRequestDto;
import com.example.demo.controller.dto.UpdateTaskResponseDto;
import com.example.demo.infrastructure.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class UpdateTaskController {

    private TaskUpdater taskUpdater;

    public UpdateTaskController(TaskUpdater taskUpdater) {
        this.taskUpdater = taskUpdater;
    }

    @PatchMapping("{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateTaskResponseDto updateTaskHandler(
            @PathVariable("taskId") Long taskId,
            @RequestBody UpdateTaskRequestDto updateTaskRequestDto) {
        String content = updateTaskRequestDto.content();

        Task task = taskUpdater.updateTask(taskId, content);

        return new UpdateTaskResponseDto(task.getId(), task.getContent());
    }
}

package com.example.demo.controller;

import com.example.demo.exception.ErrorResponse;
import com.example.demo.exception.TaskIdNotFoundException;
import com.example.demo.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ControllerAdvice
public class TaskControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TaskNotFoundException.class)
    public ErrorResponse handleTaskNotFound(TaskNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TaskIdNotFoundException.class)
    public ErrorResponse handleTaskIdNotFound(
            TaskIdNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }

}

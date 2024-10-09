package com.example.demo.exception;

public class TaskIdNotFoundException extends RuntimeException {

    public TaskIdNotFoundException(Long id) {
        super("Task " + id + "를 찾을 수 없습니다.");
    }
}

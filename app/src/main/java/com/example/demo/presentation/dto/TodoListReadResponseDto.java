package com.example.demo.presentation.dto;

import java.util.Collections;
import java.util.List;

public class TodoListReadResponseDto {
    private final List<TodoCreateResponseDto> todoList;

    public TodoListReadResponseDto(List<TodoCreateResponseDto> todoList) {
        if (todoList == null) {
            throw new IllegalArgumentException("todoList must not be null");
        }
        this.todoList = todoList;
    }

    public List<TodoCreateResponseDto> getTodoList() {
        return Collections.unmodifiableList(todoList);
    }

}

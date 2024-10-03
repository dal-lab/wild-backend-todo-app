package com.example.demo.presentation.dto;

import java.util.List;

public class TodoListReadResponseDto {
    private final List<TodoCreateResponseDto> todoList;

    public TodoListReadResponseDto(List<TodoCreateResponseDto> todoList) {
        this.todoList = todoList;
    }

    public List<TodoCreateResponseDto> getTodoList() {
        return todoList;
    }

}

package com.example.demo.presentation;

import com.example.demo.infrastructure.Todo;
import com.example.demo.infrastructure.TodoRepository;
import com.example.demo.presentation.dto.TodoCreateResponseDto;
import com.example.demo.presentation.dto.TodoListReadResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TodoListReadResource extends ResourceMethodHandler {
    static final String KEY = "GET /todos";
    private final TodoRepository todoRepository = TodoRepository.getInstance();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String handle(String content) throws JsonProcessingException {
        List<Todo> todoList = todoRepository.getTodoArrayList();
        return objectMapper.writeValueAsString(
                todoList.stream().map(
                        todo -> new TodoCreateResponseDto(
                                todo.getId(),
                                todo.getTitle(),
                                todo.isCompleted()
                        )
                ).collect(Collectors.toList())
        );
    }

    @Override
    public String getKey() {
        return KEY;
    }
}

package com.example.demo.presentation;

import com.example.demo.infrastructure.Todo;
import com.example.demo.infrastructure.TodoRepository;
import com.example.demo.presentation.dto.TodoCreateRequestDto;
import com.example.demo.presentation.dto.TodoCreateResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TodoCreateResource extends ResourceMethodHandler {
    static final String KEY = "POST /todos";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TodoRepository todoRepository = TodoRepository.getInstance();
    static int index = 0;

    @Override
    public String handle(String content) throws JsonProcessingException {
        TodoCreateRequestDto todoCreateRequestDto = objectMapper.readValue(content, TodoCreateRequestDto.class);
        Todo todo = new Todo(index, todoCreateRequestDto.title(), false);
        todoRepository.add(todo);

        return objectMapper.writeValueAsString(
                new TodoCreateResponseDto(
                        index++,
                        todoCreateRequestDto.title(),
                        false
                )
        );
    }

    @Override
    public String getKey() {
        return KEY;
    }
}

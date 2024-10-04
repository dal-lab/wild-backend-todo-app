package com.example.demo.presentation;

import com.example.demo.infrastructure.Todo;
import com.example.demo.infrastructure.TodoRepository;
import com.example.demo.presentation.dto.MessageResponseDto;
import com.example.demo.presentation.dto.TodoCreateRequestDto;
import com.example.demo.presentation.dto.TodoCreateResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TodoCreateResource extends ResourceMethodHandler {
    static final String KEY = "POST /todos";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TodoRepository todoRepository = TodoRepository.getInstance();
    static int index = 0;
    private int statusCode;

    @Override
    public String handle(String content, Integer paramId) throws JsonProcessingException {
        if (paramId != null) {
            statusCode = 400;
            return objectMapper.writeValueAsString(new MessageResponseDto("Todo를 추가하는것에 Id가 필요하지 않습니다."));
        }

        try {
            TodoCreateRequestDto todoCreateRequestDto = objectMapper.readValue(content, TodoCreateRequestDto.class);
            Todo todo = new Todo(index, todoCreateRequestDto.title());
            todoRepository.add(todo);
            statusCode = 201;
            return objectMapper.writeValueAsString(
                    new TodoCreateResponseDto(
                            index++,
                            todoCreateRequestDto.title(),
                            false
                    )
            );
        } catch (IllegalArgumentException e) {
            statusCode = 400;
            return objectMapper.writeValueAsString(new MessageResponseDto("잘못된 입력입니다: " + e.getMessage()));
        }
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }
}

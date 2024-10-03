package com.example.demo.presentation;

import com.example.demo.infrastructure.TodoRepository;
import com.example.demo.presentation.dto.MessageResponseDto;
import com.example.demo.presentation.dto.TodoDeleteRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TodoDeleteResource extends ResourceMethodHandler {
    static final String KEY = "DELETE /todos";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TodoRepository todoRepository = TodoRepository.getInstance();
    String message = "";

    @Override
    public String handle(String content) throws JsonProcessingException {
        TodoDeleteRequestDto todoDeleteRequestDto = objectMapper.readValue(content, TodoDeleteRequestDto.class);
        try {
            todoRepository.delete(todoDeleteRequestDto.id());
            message = "Todo deleted successfully: " + todoDeleteRequestDto.id();
        } catch (IllegalArgumentException e) {
            message = "Todo not found: " + todoDeleteRequestDto.id();
        }

        return objectMapper.writeValueAsString(new MessageResponseDto(
                message
        ));
    }

    @Override
    public String getKey() {
        return KEY;
    }
}

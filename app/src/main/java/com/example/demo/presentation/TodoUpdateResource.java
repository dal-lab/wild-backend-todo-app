package com.example.demo.presentation;

import com.example.demo.infrastructure.TodoRepository;
import com.example.demo.presentation.dto.MessageResponseDto;
import com.example.demo.presentation.dto.TodoUpdateRequestDto;
import com.example.demo.presentation.dto.TodoUpdateResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class TodoUpdateResource extends ResourceMethodHandler {
    static final String KEY = "PUT /todos";
    private final TodoRepository todoRepository = TodoRepository.getInstance();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String handle(String content) throws JsonProcessingException {
        TodoUpdateRequestDto todoUpdateRequestDto = objectMapper.readValue(content, TodoUpdateRequestDto.class);
        try {
            todoRepository.update(todoUpdateRequestDto.id(), Optional.ofNullable(todoUpdateRequestDto.title()), Optional.of(todoUpdateRequestDto.isCompleted()));
            return objectMapper.writeValueAsString(new TodoUpdateResponseDto(
                    todoUpdateRequestDto.id(),
                    todoUpdateRequestDto.title(),
                    todoUpdateRequestDto.isCompleted()
            ));
        } catch (IllegalArgumentException e) {
            return objectMapper.writeValueAsString(new MessageResponseDto(
                    "Todo not found: " + todoUpdateRequestDto.id()
            ));
        }


    }

    @Override
    public String getKey() {
        return KEY;
    }
}

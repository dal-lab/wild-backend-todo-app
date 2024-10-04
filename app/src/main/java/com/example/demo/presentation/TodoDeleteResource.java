package com.example.demo.presentation;

import com.example.demo.infrastructure.TodoRepository;
import com.example.demo.presentation.dto.MessageResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TodoDeleteResource extends ResourceMethodHandler {
    static final String KEY = "DELETE /todos";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TodoRepository todoRepository = TodoRepository.getInstance();
    String message = "";

    @Override
    public String handle(String content, Integer paramId) throws JsonProcessingException {
        if (paramId == null) {
            return objectMapper.writeValueAsString(new MessageResponseDto("Todo를 삭제하는데 Id가 필요합니다."));
        } else {
            try {
                todoRepository.delete(paramId);
                message = "Todo deleted successfully: " + paramId;
            } catch (IllegalArgumentException e) {
                message = "Todo not found: " + paramId;
            }
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

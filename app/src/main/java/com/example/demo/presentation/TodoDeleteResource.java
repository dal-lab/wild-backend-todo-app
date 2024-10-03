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
    private int statusCode;

    @Override
    public String handle(String content, Integer paramId) throws JsonProcessingException {
        if (paramId == null) {
            //전부 제거
            statusCode = 204;
            todoRepository.deleteAll();
            //index 초기화
            todoRepository.resetIndex();
            message = "All Todos deleted successfully";
        } else {
            try {
                statusCode = 204;
                todoRepository.delete(paramId);
                message = "Todo deleted successfully: " + paramId;
            } catch (IllegalArgumentException e) {
                statusCode = 404;
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

    @Override
    public int getStatusCode() {
        return statusCode;
    }
}

package com.example.demo.presentation;

import com.example.demo.infrastructure.Todo;
import com.example.demo.infrastructure.TodoRepository;
import com.example.demo.presentation.dto.MessageResponseDto;
import com.example.demo.presentation.dto.TodoCreateResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TodoListReadResource extends ResourceMethodHandler {
    static final String KEY = "GET /todos";
    private final TodoRepository todoRepository = TodoRepository.getInstance();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String handle(String content, Integer paramId) throws JsonProcessingException {
        if (paramId != null) {
            return objectMapper.writeValueAsString(new MessageResponseDto("Todo를 불러오는데 Id가 필요하지 않습니다."));
        } else {
            List<Todo> todoList = todoRepository.getTodoArrayList();
            return objectMapper.writeValueAsString(
                    todoList.stream().map(
                            todo -> new TodoCreateResponseDto(
                                    todo.getId(),
                                    todo.getTitle(),
                                    todo.getIsCompleted()
                            )
                    ).collect(Collectors.toList())
            );
        }
    }

    @Override
    public String getKey() {
        return KEY;
    }
}

package com.example.demo.presentation;

import com.example.demo.infrastructure.Todo;
import com.example.demo.infrastructure.TodoRepository;
import com.example.demo.presentation.dto.MessageResponseDto;
import com.example.demo.presentation.dto.TodoCreateResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.util.LoggerUtil.logger;

public class TodoListReadResource extends ResourceMethodHandler {
    static final String KEY = "GET /todos";
    private final TodoRepository todoRepository = TodoRepository.getInstance();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private int statusCode;

    @Override
    public String handle(String content, Integer paramId) throws JsonProcessingException {
        if (paramId != null) {
            logger.error("TodoListReadResource - handle - invalid paramId");
            return handleInvalidParamId();
        }
        try {
            return handleSuccessCase();
        } catch (JsonProcessingException e) {
            return handleJsonProcessingError(e);
        } catch (Exception e) {
            return handleGeneralError(e);
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

    private String handleInvalidParamId() throws JsonProcessingException {
        statusCode = 400;
        return objectMapper.writeValueAsString(new MessageResponseDto("Todo를 불러오는데 Id가 필요하지 않습니다."));
    }

    private String handleSuccessCase() throws JsonProcessingException {
        statusCode = 200;
        List<Todo> todoList = todoRepository.getTodoArrayList();
        List<TodoCreateResponseDto> todoResponseList = todoList.stream()
                .map(todo -> new TodoCreateResponseDto(todo.getId(), todo.getTitle(), todo.getIsCompleted()))
                .collect(Collectors.toList());
        return objectMapper.writeValueAsString(todoResponseList);
    }

    private String handleJsonProcessingError(JsonProcessingException e) throws JsonProcessingException {
        statusCode = 500;
        String message = "내부 서버 오류: " + e.getMessage();
        // 로깅 추가
        logger.error(message);
        return objectMapper.writeValueAsString(new MessageResponseDto(message));
    }

    private String handleGeneralError(Exception e) throws JsonProcessingException {
        statusCode = 400;
        String message = "잘못된 입력입니다: " + e.getMessage();
        // 로깅 추가
        logger.error(message);
        return objectMapper.writeValueAsString(new MessageResponseDto(message));
    }

}

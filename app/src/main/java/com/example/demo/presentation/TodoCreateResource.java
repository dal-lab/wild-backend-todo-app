package com.example.demo.presentation;

import com.example.demo.infrastructure.Todo;
import com.example.demo.infrastructure.TodoRepository;
import com.example.demo.presentation.dto.MessageResponseDto;
import com.example.demo.presentation.dto.TodoCreateRequestDto;
import com.example.demo.presentation.dto.TodoCreateResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.demo.util.LoggerUtil.logger;


public class TodoCreateResource extends ResourceMethodHandler {
    static final String KEY = "POST /todos";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final TodoRepository todoRepository = TodoRepository.getInstance();
    static int index = 0;
    private int statusCode;

    @Override
    public String handle(String content, Integer paramId) throws JsonProcessingException {
        if (paramId != null) {
            return handleInvalidParamId();
        }
        try {
            return handleSuccessCase(content);
        } catch (JsonProcessingException e) {
            return handleJsonProcessingError(e);
        } catch (IllegalArgumentException e) {
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
        return objectMapper.writeValueAsString(new MessageResponseDto("Todo를 추가하는것에 Id가 필요하지 않습니다."));
    }

    private String handleSuccessCase(String content) throws JsonProcessingException {
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
    }

    private String handleJsonProcessingError(JsonProcessingException e) throws JsonProcessingException {
        statusCode = 500;
        // 로깅 추가
        logger.error("내부 서버 오류: " + e.getMessage(), e);
        return objectMapper.writeValueAsString(new MessageResponseDto("내부 서버 오류: " + e.getMessage()));
    }

    private String handleGeneralError(Exception e) throws JsonProcessingException {
        statusCode = 400;
        // 로깅 추가
        logger.error("잘못된 입력입니다: " + e.getMessage(), e);
        return objectMapper.writeValueAsString(new MessageResponseDto("잘못된 입력입니다: " + e.getMessage()));
    }

    public static void resetIndex() {
        index = 0;
    }
}

package com.example.demo.presentation;

import com.example.demo.dto.TaskRequestDto;
import com.example.demo.dto.TaskResponseDto;
import com.example.demo.infrastructure.Task;
import com.example.demo.application.TaskCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaskCreateHandler extends ResourceMethodHandler {

    public static final String KEY = "POST /tasks";

    private final TaskCreator taskCreator = new TaskCreator();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String handle(String content) throws JsonProcessingException {
        // 어떤 형식으로 인풋을 받을 것인가?
        // 일단 , 로 나누가:


        TaskRequestDto taskRequestDto =
                objectMapper.readValue(content, TaskRequestDto.class);


        System.out.println(taskRequestDto.getTaskDescription());

        Task task = taskCreator.create(
                taskRequestDto.getTaskName(),
                taskRequestDto.getTaskDescription()
        );

        System.out.println(task.getTaskDescription());


        return objectMapper.writeValueAsString(
                new TaskResponseDto(
                        task.getTaskName(),
                        task.getTaskDescription()
                )
        );
    }
}

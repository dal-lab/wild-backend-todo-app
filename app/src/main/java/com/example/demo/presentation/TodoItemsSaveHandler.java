package com.example.demo.presentation;

import com.example.demo.application.TodoItemService;
import com.example.demo.data.TodoItem;
import com.example.demo.presentation.dto.TodoItemDto;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.List;

@Deprecated
@Component
public class TodoItemsSaveHandler implements TodoItemsHandler {
    private final TodoItemService todoItemService;
    private final Gson gson;

    public TodoItemsSaveHandler(TodoItemService todoItemService, Gson gson) {
        this.todoItemService = todoItemService;
        this.gson = gson;
    }

    @Override
    public String getKey() {
        return "POST /todoItems";
    }

    @Override
    public String handle(String requestBody) {
        //curl -i -X POST -d '{"item": "study wildbackend", "isDone": false}' localhost:8080/todoItems
        //json requestBody 받아서 dto로 변환

        //jackson lib import -> gradle 설정 파일에 dependency 설정   -> 코끼리 새로고침
        //gson 으로 해보자
        TodoItemDto todoItemDto = gson.fromJson(requestBody, TodoItemDto.class);

        System.out.println(requestBody);
        System.out.println(todoItemDto.toString());

        //save TodoItem -> application layer
        List<TodoItem> saved = todoItemService.save(new TodoItem(todoItemDto.getSeq(), todoItemDto.getItem(), todoItemDto.isDone()));

        return gson.toJson(saved);
    }
}

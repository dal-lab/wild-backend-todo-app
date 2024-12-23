package com.example.demo.presentation;

import com.example.demo.application.TodoItemService;
import com.example.demo.data.TodoItem;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.List;

@Deprecated
@Component
public class TodoItemsGetHandler implements TodoItemsHandler {

    private final TodoItemService todoItemService;
    private final Gson gson;

    public TodoItemsGetHandler(TodoItemService todoItemService, Gson gson) {
        this.todoItemService = todoItemService;
        this.gson = gson;
    }

    @Override
    public String getKey() {
        return "GET /todoItems";
    }

    @Override
    public String handle(String requestBody) {
        //application layer 에게 get요청
        List<TodoItem> retrieve = todoItemService.retrieve();

        return gson.toJson(retrieve);
    }
}

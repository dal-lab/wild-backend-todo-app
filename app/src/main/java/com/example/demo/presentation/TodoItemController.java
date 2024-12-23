package com.example.demo.presentation;

import com.example.demo.application.TodoItemService;
import com.example.demo.data.TodoItem;
import com.example.demo.presentation.dto.TodoItemDto;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todoItems")
public class TodoItemController {
    private final TodoItemService todoItemService;
    private final Gson gson;

    public TodoItemController(TodoItemService todoItemService, Gson gson) {
        this.todoItemService = todoItemService;
        this.gson = gson;
    }

    @GetMapping
    public List<TodoItemDto> list() {
        List<TodoItem> retrieve = todoItemService.retrieve();

        return retrieve.stream().map(TodoItemDto::of).toList();
    }

    @PostMapping
    public String add(@RequestBody TodoItemDto todoItemDto) {
        //save TodoItem -> application layer
        List<TodoItem> saved = todoItemService.save(new TodoItem(todoItemDto.getSeq(), todoItemDto.getItem(), todoItemDto.isDone()));

        return gson.toJson(saved);
    }
}

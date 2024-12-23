package com.example.demo.application;

import com.example.demo.data.TodoItem;
import com.example.demo.data.TodoItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TodoItemService {
    private final TodoItemRepository todoItemRepository;

    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public List<TodoItem> save(TodoItem todoItem) {

        List<TodoItem> savedTodoItems = todoItemRepository.get();
        Optional<TodoItem> first = savedTodoItems.stream()
                .filter(saved -> saved.getSeq() == todoItem.getSeq()).findFirst();
        if(first.isPresent()) { //update
            first.get().setItem(todoItem.getItem());
            first.get().setDone(todoItem.isDone());

            return todoItemRepository.get();
        }

        todoItemRepository.add(todoItem); //insert

        return todoItemRepository.get();
    }

    public List<TodoItem> retrieve() {
        return todoItemRepository.get();
    }
}

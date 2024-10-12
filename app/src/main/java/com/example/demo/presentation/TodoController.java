package com.example.demo.presentation;

import com.example.demo.infrastructure.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/todos")
public class TodoController {
    List<Todo> todoRepository = new ArrayList<>();


    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Todo> list() {
        return todoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody Todo todo) {
        int newId = todoRepository.size() + 1; // 임의의 id 생성 로직
        Todo newTodo = new Todo(newId, todo.getTitle());
        todoRepository.add(newTodo);
        return newTodo;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo edit(@PathVariable int id, @RequestBody Todo requestedTodo) {
        Todo editedTodo = todoRepository.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found: " + id));

        if (!requestedTodo.getTitle().isEmpty() && Objects.nonNull(requestedTodo.getTitle())) {
            editedTodo.setTitle(requestedTodo.getTitle());
        }
        if (Objects.nonNull(requestedTodo.getIsCompleted())) {
            editedTodo.setCompleted(requestedTodo.getIsCompleted());
        }

        return editedTodo;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        todoRepository.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .ifPresentOrElse(todoRepository::remove, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found: " + id);
                });
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        todoRepository.clear();
    }
}

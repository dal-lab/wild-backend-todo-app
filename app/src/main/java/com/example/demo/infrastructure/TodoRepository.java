package com.example.demo.infrastructure;

import java.util.ArrayList;
import java.util.Optional;

public class TodoRepository {
    private final ArrayList<Todo> todoArrayList = new ArrayList<>();
    private static TodoRepository instance = null;

    public void add(Todo todo) {
        todoArrayList.add(todo);
    }

    public ArrayList<Todo> getTodoArrayList() {
        return todoArrayList;
    }

    public static TodoRepository getInstance() {
        if (instance == null) {
            instance = new TodoRepository();
        }
        return instance;
    }

    public void delete(int id) {
        boolean found = false;
        for (int i = 0; i < todoArrayList.size(); i++) {
            if (todoArrayList.get(i).getId() == id) {
                todoArrayList.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Todo with id " + id + " not found.");
        }
    }

    public Todo update(Integer id, Optional<String> title, Optional<Boolean> isCompleted) {
        Todo todoToUpdate = todoArrayList.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Todo with id " + id + " not found.");
                });

        title.ifPresent(todoToUpdate::setTitle);
        isCompleted.ifPresent(todoToUpdate::setCompleted);

        return todoToUpdate;
    }

}

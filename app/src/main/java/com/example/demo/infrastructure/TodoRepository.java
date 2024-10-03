package com.example.demo.infrastructure;

import java.util.ArrayList;

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

    public void update(int id, String title, Boolean isCompleted) {
        boolean found = false;
        for (int i = 0; i < todoArrayList.size(); i++) {
            if (todoArrayList.get(i).getId() == id) {
                Todo existingTodo = todoArrayList.get(i);
                if (title == null) {
                    title = existingTodo.getTitle();
                }
                if (isCompleted == null) {
                    isCompleted = existingTodo.isCompleted();
                }
                todoArrayList.set(i, new Todo(
                        id,
                        title
                ));
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Todo with id " + id + " not found.");
        }
    }
}

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
}

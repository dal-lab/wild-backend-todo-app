package com.example.demo.presentation.dto;

import com.example.demo.data.TodoItem;

public class TodoItemDto {
    private int seq;
    private String item;
    private boolean isDone;

    public int getSeq() {
        return seq;
    }

    public String getItem() {
        return item;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "seq=" + seq + "item=" + item + ", isDone=" + isDone;
    }

    public static TodoItemDto of(TodoItem item) {
        TodoItemDto dto = new TodoItemDto();
        dto.setSeq(item.getSeq());
        dto.setItem(item.getItem());
        dto.setDone(item.isDone());
        return dto;
    }
}

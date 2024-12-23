package com.example.demo.data;

public class TodoItem {
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

    public TodoItem(int seq, String item, boolean isDone) {
        this.seq = seq;
        this.item = item;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "seq=" + seq + "item=" + item + ", isDone=" + isDone;
    }
}

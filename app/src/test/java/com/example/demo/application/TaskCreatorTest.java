package com.example.demo.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TaskCreatorTest {

    private TaskCreator taskCreator;

    @BeforeEach
    void setUp() {
        taskCreator = new TaskCreator();
    }

    @Test
    void save() {
        String content = "오늘 할 일";

        taskCreator.createTask(content);
    }
}

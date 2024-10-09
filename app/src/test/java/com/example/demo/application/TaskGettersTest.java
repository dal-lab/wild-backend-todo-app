package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskGettersTest {

    private TaskGetters taskGetters;

    @BeforeEach
    void setUp() {
        taskGetters = new TaskGetters();
    }

    @Test
    void shouldReturnTasks() {
        String listTask = taskGetters.getListTask();

        assertThat(listTask).isEqualTo("success");
    }
}

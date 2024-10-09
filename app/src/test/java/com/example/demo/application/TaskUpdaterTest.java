package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskUpdaterTest {

    private TaskUpdater taskUpdater;

    @BeforeEach
    void setUp() {
        taskUpdater = new TaskUpdater();
    }

    @Test
    void ShouldReturnUpdateTask() {
        String updatedTask = taskUpdater.updateTask(1L, "내일 할 일");

        assertThat(updatedTask).isEqualTo("success");
    }
}

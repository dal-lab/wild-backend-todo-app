package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskFinderTest {

    private TaskFinder taskFinder;

    @BeforeEach
    void setUp() {
        taskFinder = new TaskFinder();
    }

    @Test
    void shouldReturnTask() {
        String task = taskFinder.getTask(1L);

        assertThat(task).isEqualTo("Success");
    }
}

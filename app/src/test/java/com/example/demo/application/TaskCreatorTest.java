package com.example.demo.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.example.demo.infrastructure.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TaskCreatorTest {

    private TaskCreator taskCreator;
    private TaskRepository taskRepository;


    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskCreator = new TaskCreator(taskRepository);
    }

    @Test
    void save() {
        String content = "오늘 할 일";
        taskCreator.createTask(content);

        verify(taskRepository).save(any());
    }
}

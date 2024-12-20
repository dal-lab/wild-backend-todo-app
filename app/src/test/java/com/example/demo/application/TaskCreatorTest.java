package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TaskCreatorTest {
    private TaskRepository taskRepository;
    private TaskCreator taskCreator;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskCreator = new TaskCreator(taskRepository);
    }

    @Test
    void simpleAdd() {
        Task task = taskCreator.create("test1", "test123");

        assertThat(task.getTaskName()).isEqualTo("test1");
        assertThat(task.getTaskDescription()).isEqualTo("test123");

        verify(taskRepository).add(any());

    }

    @Test
    void getTaskList() {

        when(taskRepository.getTasks()).thenReturn(List.of(
                new Task("test0", "test0123")
        ));

        List<Task> tasks = taskCreator.getTasks();

        assertThat(tasks).hasSize(1);
    }


}

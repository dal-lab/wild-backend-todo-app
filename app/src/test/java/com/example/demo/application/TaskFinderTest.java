package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskFinderTest {

    private TaskFinder taskFinder;
    private TaskRepository taskRepository;

    Task mockTask = new Task(1L, "오늘 할 일");

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskFinder = new TaskFinder(taskRepository);

        given(taskRepository.findById(1L)).willReturn(
                Optional.of(mockTask));
    }

    @Test
    void shouldReturnTask() {
        Task task = taskFinder.getTask(1L);

        assertThat(task).isEqualTo(mockTask);
    }
}

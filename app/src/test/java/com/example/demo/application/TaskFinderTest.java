package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.example.demo.exception.TaskIdNotFoundException;
import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskFinderTest {

    private TaskFinder taskFinder;
    private TaskRepository taskRepository;

    private static Long existentTaskId = 1L;
    private static Long nonExistentTaskId = 9999L;
    private static String existentContent = "오늘 할 일";

    Task mockTask = new Task(existentTaskId, existentContent);

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskFinder = new TaskFinder(taskRepository);

        given(taskRepository.findById(existentTaskId)).willReturn(
                Optional.of(mockTask));
    }

    @Test
    void shouldReturnTask() {
        Task task = taskFinder.getTask(existentTaskId);

        assertThat(task).isEqualTo(mockTask);
    }


    @Test
    void shouldReturnEmpor() {
        assertThatThrownBy(() -> taskFinder.getTask(nonExistentTaskId))
                .isInstanceOf(TaskIdNotFoundException.class)
                .hasMessage("Task 9999를 찾을 수 없습니다.");

    }
}

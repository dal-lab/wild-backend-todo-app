package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskUpdaterTest {

    private TaskUpdater taskUpdater;
    private TaskRepository taskRepository;

    private static Long existentTaskId = 1L;
    private static Long nonExistentTaskId = 9999L;
    private static String existentContent = "오늘 할 일";

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskUpdater = new TaskUpdater(taskRepository);

        Task mockTask = new Task(existentTaskId, existentContent);
        given(taskRepository.findById(1L)).willReturn(
                Optional.of(mockTask));
    }

    @Test
    void ShouldReturnUpdateTask() {
        Task task = taskUpdater.updateTask(existentTaskId, existentContent);

        assertThat(task.getContent()).isEqualTo(existentContent);
    }

    @Test
    void shouldThrowExceptionWhenTaskNotFound() {
        assertThatThrownBy(() -> taskUpdater.updateTask(nonExistentTaskId,
                existentContent))
                .isInstanceOf(TaskNotFoundException.class)
                .hasMessage("해당 Task를 찾을 수 없습니다.");
    }
}

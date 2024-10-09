package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskUpdaterTest {

    private TaskUpdater taskUpdater;
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskUpdater = new TaskUpdater(taskRepository);

        Task mockTask = new Task(1L, "오늘 할 일");
        given(taskRepository.findById(1L)).willReturn(
                Optional.of(mockTask));
    }

    @Test
    void ShouldReturnUpdateTask() {
        Task task = taskUpdater.updateTask(1L, "내일 할 일");

        assertThat(task.getContent()).isEqualTo("내일 할 일");

        verify(taskRepository).save(task);
    }

    @Test
    void shouldThrowExceptionWhenTaskNotFound() {
        given(taskRepository.findById(2L)).willReturn(Optional.empty());

        assertThatThrownBy(() -> taskUpdater.updateTask(999L, "오늘 할 일"))
                .isInstanceOf(TaskNotFoundException.class)
                .hasMessage("해당 Task를 찾을 수 없습니다.");
    }
}

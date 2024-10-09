package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.example.demo.exception.TaskIdNotFoundException;
import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskRemoverTest {

    private TaskRemover taskRemover;

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskRemover = new TaskRemover(taskRepository);

        given(taskRepository.findById(1L)).willReturn(
                Optional.of(new Task(1L, "오늘 할 일")));

        given(taskRepository.findById(9999L)).willReturn(Optional.empty());

        given(taskRepository.remove(1L)).willReturn(true);
    }

    @Test
    void shouldReturnTrueIfRemoveSuccess() {
        boolean isRemoveTask = taskRemover.removeTask(1L);

        assertThat(isRemoveTask).isTrue();
    }

    @Test
    void shouldReturnFalseIfRemoveFail() {
        assertThatThrownBy(() -> taskRemover.removeTask(9999L))
                .isInstanceOf(TaskIdNotFoundException.class)
                .hasMessage("Task 9999를 찾을 수 없습니다.");
    }
}

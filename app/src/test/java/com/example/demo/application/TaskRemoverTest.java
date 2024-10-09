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

class TaskRemoverTest {

    private TaskRemover taskRemover;

    private TaskRepository taskRepository;

    private static Long existentTaskId = 1L;
    private static Long nonExistentTaskId = 9999L;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskRemover = new TaskRemover(taskRepository);

        given(taskRepository.findById(existentTaskId)).willReturn(
                Optional.of(new Task(existentTaskId, "오늘 할 일")));

        given(taskRepository.findById(nonExistentTaskId)).willReturn(
                Optional.empty());

        given(taskRepository.remove(existentTaskId)).willReturn(true);
    }

    @Test
    void shouldReturnTrueIfRemoveSuccess() {
        boolean isRemoveTask = taskRemover.removeTask(existentTaskId);

        assertThat(isRemoveTask).isTrue();
    }

    @Test
    void shouldReturnFalseIfRemoveFail() {
        assertThatThrownBy(() -> taskRemover.removeTask(nonExistentTaskId))
                .isInstanceOf(TaskIdNotFoundException.class)
                .hasMessage("Task 9999를 찾을 수 없습니다.");
    }
}

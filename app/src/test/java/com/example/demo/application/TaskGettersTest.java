package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskGettersTest {

    private TaskGetters taskGetters;
    private TaskRepository taskRepository;

    private static Long firstTaskId = 1L;
    private static Long secondTaskID = 2L;
    private static String firstContent = "오늘 할 일";
    private static String secondContent = "오늘 할 일";

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskGetters = new TaskGetters(taskRepository);
    }

    @Test
    void shouldReturnTasks() {
        List<Task> mockTasks = Arrays.asList(
                new Task(firstTaskId, firstContent),
                new Task(secondTaskID, secondContent)
        );

        given(taskRepository.findAll()).willReturn(mockTasks);

        List<Task> tasks = taskGetters.getListTask();

        assertThat(tasks).hasSize(2);
        assertThat(tasks).isEqualTo(mockTasks);
    }

    @Test
    void shouldReturnEmptyListWhenNoTasks() {
        given(taskRepository.findAll()).willReturn(List.of());

        assertThatThrownBy(() -> taskGetters.getListTask())
                .isInstanceOf(TaskNotFoundException.class)
                .hasMessage("해당 Task 정보를 찾을 수 없습니다.");
    }
}

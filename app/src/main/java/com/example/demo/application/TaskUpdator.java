package com.example.demo.application;

import com.example.demo.infrastructure.Task;
import com.example.demo.infrastructure.TaskRepository;
import com.example.demo.infrastructure.TaskRepositoryImp;
import java.util.Optional;

public class TaskUpdator {

    private final TaskRepository taskRepository = TaskRepositoryImp.getInstance();

    public String updateTask(long id, String content) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setContent(content);
        }

        return content;
    }
}

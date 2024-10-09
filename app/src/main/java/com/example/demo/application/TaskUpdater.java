package com.example.demo.application;

import org.springframework.stereotype.Component;

@Component
public class TaskUpdater {

    public String updateTask(Long id, String content) {
        return "success";
    }

}

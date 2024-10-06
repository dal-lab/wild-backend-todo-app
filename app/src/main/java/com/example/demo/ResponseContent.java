package com.example.demo;

import com.example.demo.controller.CreateTaskResource;
import com.example.demo.controller.FindTaskResource;
import com.example.demo.controller.HomeResource;
import com.example.demo.controller.ListTaskResource;
import com.example.demo.controller.RemoveTaskResource;
import com.example.demo.controller.UpdateTaskResource;
import java.io.IOException;

public class ResponseContent {

    // 멤버 변수로 핸들러 인스턴스 생성
    private final HomeResource homeResource;
    private final CreateTaskResource createTaskResource;
    private final ListTaskResource listTaskResource;
    private final FindTaskResource findTaskResource;
    private final UpdateTaskResource updateTaskResource;
    private final RemoveTaskResource removeTaskResource;
    private final TaskPathId taskPathId;

    // 생성자에서 인스턴스 초기화
    public ResponseContent() {
        this.homeResource = new HomeResource();
        this.createTaskResource = new CreateTaskResource();
        this.listTaskResource = new ListTaskResource();
        this.findTaskResource = new FindTaskResource();
        this.updateTaskResource = new UpdateTaskResource();
        this.removeTaskResource = new RemoveTaskResource();
        this.taskPathId = new TaskPathId();
    }

    public String getResponseContent(String requestMethod, String requestUri,
            String requestContent) throws IOException {

        if (requestMethod.equals("GET") && requestUri.equals("/")) {
            return homeResource.handler();
        }

        if (requestMethod.equals("POST") && requestUri.equals("/tasks")) {
            return createTaskResource.handler(requestContent);
        }

        if (requestMethod.equals("GET") && requestUri.equals("/tasks")) {
            return listTaskResource.handler();
        }

        if (requestMethod.equals("GET") && requestUri.startsWith("/tasks/")) {
            Long taskId = taskPathId.getPathId(requestUri);
            return findTaskResource.handler(taskId);
        }

        if (requestMethod.equals("PATCH") && requestUri.startsWith("/tasks/")) {
            Long taskId = taskPathId.getPathId(requestUri);
            return updateTaskResource.handler(taskId, requestContent);
        }

        if (requestMethod.equals("DELETE") && requestUri.startsWith(
                "/tasks/")) {
            Long taskId = taskPathId.getPathId(requestUri);
            return removeTaskResource.handler(taskId);
        }

        return null;
    }

}

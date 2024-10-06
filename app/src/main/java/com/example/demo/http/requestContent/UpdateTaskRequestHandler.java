package com.example.demo.http.requestContent;

import com.example.demo.controller.UpdateTaskResource;
import com.example.demo.http.request.RequestAttribute;
import java.io.IOException;

public class UpdateTaskRequestHandler implements RequestHandlerStrategy {

    private final UpdateTaskResource updateTaskResource = new UpdateTaskResource();
    private final TaskPathId taskPathId = new TaskPathId();

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return isPatch(requestAttribute);
    }

    @Override
    public String handle(RequestAttribute requestAttribute) throws IOException {
        Long taskId = taskPathId.getPathId(requestAttribute.requestURI());
        return updateTaskResource.handler(taskId,
                requestAttribute.requestContent());
    }

    private boolean isPatch(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals("PATCH")
                && requestAttribute.requestURI().startsWith("/tasks/");
    }
}


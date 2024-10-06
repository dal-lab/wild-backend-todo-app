package com.example.demo.http.requestContent;

import com.example.demo.controller.RemoveTaskResource;
import com.example.demo.http.request.RequestAttribute;

public class RemoveTaskRequestHandler implements RequestHandlerStrategy {

    private final RemoveTaskResource removeTaskResource = new RemoveTaskResource();
    private final TaskPathId taskPathId = new TaskPathId();

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return isDelete(requestAttribute);
    }

    @Override
    public String handle(RequestAttribute requestAttribute) {
        Long taskId = taskPathId.getPathId(requestAttribute.requestURI());
        return removeTaskResource.handler(taskId);
    }

    private boolean isDelete(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals("DELETE")
                && requestAttribute.requestURI().startsWith(
                "/tasks/");
    }
}

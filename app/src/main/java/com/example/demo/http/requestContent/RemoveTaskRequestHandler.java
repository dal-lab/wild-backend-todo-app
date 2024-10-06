package com.example.demo.http.requestContent;

import com.example.demo.controller.RemoveTaskResource;
import com.example.demo.http.method.DeleteMethod;
import com.example.demo.http.request.RequestAttribute;

public class RemoveTaskRequestHandler implements RequestHandlerStrategy {

    private final TaskPathId taskPathId = new TaskPathId();

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return new DeleteMethod("/tasks/").isMethod(requestAttribute);
    }

    @Override
    public String handle(RequestAttribute requestAttribute) {
        Long taskId = taskPathId.getPathId(requestAttribute.requestURI());
        return new RemoveTaskResource().handler(taskId);
    }
}

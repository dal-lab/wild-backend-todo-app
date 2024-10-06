package com.example.demo.http.requestContent;

import com.example.demo.controller.RemoveTaskResource;
import com.example.demo.http.method.DeleteMethod;
import com.example.demo.http.request.RequestAttribute;

public class RemoveTaskRequestHandler implements RequestHandlerStrategy {

    private final String URI_PREFIX = "/tasks/";

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return new DeleteMethod(URI_PREFIX).isMethod(requestAttribute);
    }

    @Override
    public String handle(RequestAttribute requestAttribute) {
        Long taskId = new TaskPathId().getPathId(requestAttribute.requestURI(),
                URI_PREFIX);

        return new RemoveTaskResource().handler(taskId);
    }
}

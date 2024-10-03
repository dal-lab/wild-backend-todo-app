package com.example.demo.http.requestContent;

import com.example.demo.controller.UpdateTaskResource;
import com.example.demo.http.method.PatchMethod;
import com.example.demo.http.request.RequestAttribute;
import java.io.IOException;

public class UpdateTaskRequestHandler implements RequestHandlerStrategy {

    private final String URI_PREFIX = "/tasks/";

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return new PatchMethod(URI_PREFIX).isMethod(requestAttribute);
    }

    @Override
    public String handle(RequestAttribute requestAttribute) throws IOException {
        Long taskId = new TaskPathId(URI_PREFIX).getPathId(
                requestAttribute.requestURI());
        return new UpdateTaskResource().handler(taskId,
                requestAttribute.requestContent());
    }
}


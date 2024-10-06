package com.example.demo.http.requestContent;

import com.example.demo.controller.UpdateTaskResource;
import com.example.demo.http.method.PatchMethod;
import com.example.demo.http.request.RequestAttribute;
import java.io.IOException;

public class UpdateTaskRequestHandler implements RequestHandlerStrategy {

    private final TaskPathId taskPathId = new TaskPathId();
    private final String URI_PREFIX = "/tasks/";

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return new PatchMethod(URI_PREFIX).isMethod(requestAttribute);
    }

    @Override
    public String handle(RequestAttribute requestAttribute) throws IOException {
        Long taskId = taskPathId.getPathId(requestAttribute.requestURI(),
                URI_PREFIX);
        return new UpdateTaskResource().handler(taskId,
                requestAttribute.requestContent());
    }
}


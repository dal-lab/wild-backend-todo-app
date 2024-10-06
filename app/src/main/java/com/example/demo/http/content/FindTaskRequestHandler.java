package com.example.demo.http.content;

import com.example.demo.controller.FindTaskResource;
import com.example.demo.http.RequestAttribute;
import com.example.demo.http.TaskPathId;
import java.io.IOException;

public class FindTaskRequestHandler implements RequestHandlerStrategy {

    private final FindTaskResource findTaskResource = new FindTaskResource();
    private final TaskPathId taskPathId = new TaskPathId();

    @Override
    public boolean matches(final RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals("GET")
                && requestAttribute.requestURI().startsWith("/tasks/");
    }

    @Override
    public String handle(final RequestAttribute requestAttribute)
            throws IOException {
        Long taskId = taskPathId.getPathId(requestAttribute.requestURI());
        return findTaskResource.handler(taskId);
    }
}

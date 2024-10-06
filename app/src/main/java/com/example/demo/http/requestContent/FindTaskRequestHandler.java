package com.example.demo.http.requestContent;

import com.example.demo.controller.FindTaskResource;
import com.example.demo.http.method.GetMethod;
import com.example.demo.http.request.RequestAttribute;
import java.io.IOException;

public class FindTaskRequestHandler implements RequestHandlerStrategy {

    private final String URI_PREFIX = "/tasks/";

    @Override
    public boolean matches(final RequestAttribute requestAttribute) {
        return new GetMethod(URI_PREFIX).isMethod(requestAttribute);
    }

    @Override
    public String handle(final RequestAttribute requestAttribute)
            throws IOException {
        Long taskId = new TaskPathId().getPathId(requestAttribute.requestURI(),
                URI_PREFIX);

        return new FindTaskResource().handler(taskId);
    }
}

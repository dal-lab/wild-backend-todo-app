package com.example.demo.http.requestContent;

import com.example.demo.controller.CreateTaskResource;
import com.example.demo.http.request.RequestAttribute;
import java.io.IOException;

public class CreateTaskRequestHandler implements RequestHandlerStrategy {

    private final CreateTaskResource createTaskResource = new CreateTaskResource();

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return isPost(requestAttribute);
    }

    @Override
    public String handle(RequestAttribute requestAttribute) throws IOException {
        return createTaskResource.handler(requestAttribute.requestContent());
    }

    private boolean isPost(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals("POST")
                && requestAttribute.requestURI().equals("/tasks");
    }
}

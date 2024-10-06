package com.example.demo.http.content;

import com.example.demo.controller.CreateTaskResource;
import com.example.demo.http.RequestAttribute;
import java.io.IOException;

public class CreateTaskRequestHandler implements RequestHandlerStrategy {
    CreateTaskResource createTaskResource = new CreateTaskResource();

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals("POST")
                && requestAttribute.requestURI().equals("/tasks");
    }

    @Override
    public String handle(RequestAttribute requestAttribute) throws IOException {
        return createTaskResource.handler(requestAttribute.requestContent());
    }
}

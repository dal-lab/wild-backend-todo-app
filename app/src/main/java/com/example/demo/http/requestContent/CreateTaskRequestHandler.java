package com.example.demo.http.requestContent;

import com.example.demo.controller.CreateTaskResource;
import com.example.demo.http.method.PostMethod;
import com.example.demo.http.request.RequestAttribute;
import java.io.IOException;

public class CreateTaskRequestHandler implements RequestHandlerStrategy {

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return new PostMethod("/tasks").isMethod(requestAttribute);
    }

    @Override
    public String handle(RequestAttribute requestAttribute) throws IOException {
        return new CreateTaskResource().handler(
                requestAttribute.requestContent());
    }
}

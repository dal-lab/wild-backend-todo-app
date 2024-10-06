package com.example.demo.http.requestContent;

import com.example.demo.controller.ListTaskResource;
import com.example.demo.http.request.RequestAttribute;
import java.io.IOException;

public class ListTaskRequestHandler implements RequestHandlerStrategy {

    private final ListTaskResource listTaskResource = new ListTaskResource();

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals("GET")
                && requestAttribute.requestURI().equals("/tasks");
    }

    @Override
    public String handle(RequestAttribute requestAttribute) throws IOException {
        return listTaskResource.handler();
    }
}

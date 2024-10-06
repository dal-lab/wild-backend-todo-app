package com.example.demo.http.requestContent;

import com.example.demo.controller.HomeResource;
import com.example.demo.http.method.ListMethod;
import com.example.demo.http.request.RequestAttribute;

public class HomeRequestHandler implements RequestHandlerStrategy {

    private final HomeResource homeResource = new HomeResource();

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return new ListMethod("/").isMethod(requestAttribute);
    }

    @Override
    public String handle(RequestAttribute requestAttribute) {
        return homeResource.handler();
    }
}

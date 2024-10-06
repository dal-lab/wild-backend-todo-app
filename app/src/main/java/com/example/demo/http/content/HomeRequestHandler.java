package com.example.demo.http.content;

import com.example.demo.controller.HomeResource;
import com.example.demo.http.RequestAttribute;

public class HomeRequestHandler implements RequestHandlerStrategy {

    private final HomeResource homeResource = new HomeResource();

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals("GET")
                && requestAttribute.requestURI().equals("/");
    }

    @Override
    public String handle(RequestAttribute requestAttribute) {
        return homeResource.handler();
    }
}

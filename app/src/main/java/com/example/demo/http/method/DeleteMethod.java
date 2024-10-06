package com.example.demo.http.method;

import com.example.demo.http.request.RequestAttribute;

public class DeleteMethod implements RequestMethodHandler {

    private final String DELETE = "DELETE";
    private final String uriPrefix;

    public DeleteMethod(String uriPrefix) {
        this.uriPrefix = uriPrefix;
    }

    @Override
    public boolean isMethod(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals(DELETE)
                && requestAttribute.requestURI().startsWith(
                uriPrefix);
    }
}

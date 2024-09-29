package com.example.demo.http.method;

import com.example.demo.http.request.RequestAttribute;

public class DeleteMethod extends RequestMethodHandler {

    private final String DELETE = "DELETE";

    public DeleteMethod(String uriPrefix) {
        super(uriPrefix);
    }

    @Override
    public boolean isMethod(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals(DELETE)
                && requestAttribute.requestURI().startsWith(
                uriPrefix);
    }
}

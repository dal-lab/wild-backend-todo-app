package com.example.demo.http.method;

import com.example.demo.http.request.RequestAttribute;

public class PostMethod implements RequestMethodHandler {

    private final String POST = "POST";
    private final String uriPrefix;

    public PostMethod(String uriPrefix) {
        this.uriPrefix = uriPrefix;
    }

    @Override
    public boolean isMethod(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals(POST)
                && requestAttribute.requestURI().equals(uriPrefix);
    }
}

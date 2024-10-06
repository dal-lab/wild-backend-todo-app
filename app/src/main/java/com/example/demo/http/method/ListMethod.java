package com.example.demo.http.method;

import com.example.demo.http.request.RequestAttribute;

public class ListMethod implements RequestMethodHandler {

    private final String GET = "GET";
    private final String uriPrefix;

    public ListMethod(String uriPrefix) {
        this.uriPrefix = uriPrefix;
    }

    @Override
    public boolean isMethod(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals(GET)
                && requestAttribute.requestURI().equals(uriPrefix);
    }
}

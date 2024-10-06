package com.example.demo.http.method;

import com.example.demo.http.request.RequestAttribute;

public class GetMethod implements RequestMethodHandler {

    private final String GET = "GET";
    private final String uriPrefix;

    public GetMethod(String uriPrefix) {
        this.uriPrefix = uriPrefix;
    }

    @Override
    public boolean isMethod(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals(GET)
                && requestAttribute.requestURI().startsWith(uriPrefix);
    }
}

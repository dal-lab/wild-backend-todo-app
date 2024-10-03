package com.example.demo.http.method;

import com.example.demo.http.request.RequestAttribute;

public class ListMethod extends RequestMethodHandler {

    private final String GET = "GET";

    public ListMethod(String uriPrefix) {
        super(uriPrefix);
    }

    @Override
    public boolean isMethod(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals(GET)
                && requestAttribute.requestURI().equals(uriPrefix);
    }
}

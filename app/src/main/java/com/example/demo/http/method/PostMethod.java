package com.example.demo.http.method;

import com.example.demo.http.request.RequestAttribute;

public class PostMethod extends RequestMethodHandler {

    private final String POST = "POST";

    public PostMethod(String uriPrefix) {
        super(uriPrefix);
    }

    @Override
    public boolean isMethod(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals(POST)
                && requestAttribute.requestURI().equals(uriPrefix);
    }
}

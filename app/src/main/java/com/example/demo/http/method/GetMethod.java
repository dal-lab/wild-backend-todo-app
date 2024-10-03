package com.example.demo.http.method;

import com.example.demo.http.request.RequestAttribute;

public class GetMethod extends RequestMethodHandler {

    private final String GET = "GET";

    public GetMethod(String uriPrefix) {
        super(uriPrefix);
    }

    @Override
    public boolean isMethod(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals(GET)
                && requestAttribute.requestURI().startsWith(uriPrefix);
    }
}

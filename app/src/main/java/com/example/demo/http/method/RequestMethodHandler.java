package com.example.demo.http.method;

import com.example.demo.http.request.RequestAttribute;

public abstract class RequestMethodHandler {

    protected final String uriPrefix;

    RequestMethodHandler(String uriPrefix) {
        this.uriPrefix = uriPrefix;
    }

    public abstract boolean isMethod(RequestAttribute requestAttribute);
}

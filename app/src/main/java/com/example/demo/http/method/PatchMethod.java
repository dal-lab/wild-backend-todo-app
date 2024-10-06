package com.example.demo.http.method;

import com.example.demo.http.request.RequestAttribute;

public class PatchMethod implements RequestMethodHandler {

    private final String PATCH = "PATCH";
    private final String uriPrefix;

    public PatchMethod(String uriPrefix) {
        this.uriPrefix = uriPrefix;
    }

    @Override
    public boolean isMethod(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals(PATCH)
                && requestAttribute.requestURI().startsWith(uriPrefix);
    }
}

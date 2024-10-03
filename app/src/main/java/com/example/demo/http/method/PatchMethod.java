package com.example.demo.http.method;

import com.example.demo.http.request.RequestAttribute;

public class PatchMethod extends RequestMethodHandler {

    private final String PATCH = "PATCH";

    public PatchMethod(String uriPrefix) {
        super(uriPrefix);
    }

    @Override
    public boolean isMethod(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals(PATCH)
                && requestAttribute.requestURI().startsWith(uriPrefix);
    }
}

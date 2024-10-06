package com.example.demo.http.method;

import com.example.demo.http.request.RequestAttribute;

public interface RequestMethodHandler {

    boolean isMethod(RequestAttribute requestAttribute);
}

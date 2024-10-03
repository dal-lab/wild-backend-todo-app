package com.example.demo.http.request;

public record RequestAttribute(
        String requestContent,
        String requestMethod,
        String requestURI
) {

}

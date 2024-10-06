package com.example.demo.http;

public record RequestAttribute(
        String requestContent,
        String requestMethod,
        String requestURI
) {

}

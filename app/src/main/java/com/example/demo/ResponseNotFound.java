package com.example.demo;

import com.sun.net.httpserver.HttpExchange;

public class ResponseNotFound extends Response {

    private static final int STATUS_CODE = 404;

    public ResponseNotFound(HttpExchange exchange) {
        super(exchange);
    }

    @Override
    protected int httpStatusCode() {
        return STATUS_CODE;
    }
}

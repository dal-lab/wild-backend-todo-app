package com.example.demo.http;

import com.sun.net.httpserver.HttpExchange;

public class ResponseSuccess extends Response {

    private static final int STATUS_CODE = 200;

    public ResponseSuccess(HttpExchange exchange) {
        super(exchange);
    }

    @Override
    protected int httpStatusCode() {
        return STATUS_CODE;
    }
}

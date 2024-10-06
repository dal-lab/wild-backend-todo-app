package com.example.demo.http.response;

import com.sun.net.httpserver.HttpExchange;

public class ResponseNotFound extends Response {

    private static final int STATUS_CODE = 404;

    public ResponseNotFound(HttpExchange exchange) {
        super(exchange, STATUS_CODE);
    }
}

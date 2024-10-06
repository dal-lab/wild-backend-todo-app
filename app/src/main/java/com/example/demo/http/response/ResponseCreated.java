package com.example.demo.http.response;

import com.sun.net.httpserver.HttpExchange;

public class ResponseCreated extends Response {

    private static final int STATUS_CODE = 201;

    ResponseCreated(HttpExchange exchange) {
        super(exchange, STATUS_CODE);
    }
}

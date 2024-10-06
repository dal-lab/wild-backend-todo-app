package com.example.demo;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class ResponseNotFound {

    private static final int STATUS_CODE = 404;

    private final HttpExchange exchange;

    public ResponseNotFound(HttpExchange exchange) {
        this.exchange = exchange;
    }

    public void send() throws IOException {
        exchange.sendResponseHeaders(STATUS_CODE, -1);
    }
}

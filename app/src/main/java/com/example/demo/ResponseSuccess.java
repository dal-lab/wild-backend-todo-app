package com.example.demo;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class ResponseSuccess {

    private static final int STATUS_CODE = 200;

    private final HttpExchange exchange;

    public ResponseSuccess(HttpExchange exchange) {
        this.exchange = exchange;
    }

    public void send(String responseContent) throws IOException {
        byte[] bytes = responseContent.getBytes();

        exchange.sendResponseHeaders(STATUS_CODE, bytes.length);
        exchange.getResponseBody().write(bytes);
    }
}

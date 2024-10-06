package com.example.demo.http.response;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public abstract class Response {
    private final HttpExchange exchange;
    private final int statusCode;

    Response(HttpExchange exchange, int statusCode) {
        this.exchange = exchange;
        this.statusCode = statusCode;
    }

    public void send(String responseContent) throws IOException {
        byte[] bytes = responseContent.getBytes();

        exchange.sendResponseHeaders(this.statusCode, bytes.length);
        exchange.getResponseBody().write(bytes);
    }
}

package com.example.demo.http.response;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public abstract class Response {
    private final HttpExchange exchange;

    Response(HttpExchange exchange) {
        this.exchange = exchange;
    }

    public void send(String responseContent) throws IOException {
        byte[] bytes = responseContent.getBytes();

        exchange.sendResponseHeaders(httpStatusCode(), bytes.length);
        exchange.getResponseBody().write(bytes);
    }

    protected abstract int httpStatusCode();
}

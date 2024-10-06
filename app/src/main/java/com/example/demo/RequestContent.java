package com.example.demo;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.InputStream;

public class RequestContent {

    private final HttpExchange exchange;

    public RequestContent(HttpExchange exchange) {
        this.exchange = exchange;
    }

    public String getRequestContent() throws IOException {
        InputStream inputStream = this.exchange.getRequestBody();
        return new String(inputStream.readAllBytes());
    }
}

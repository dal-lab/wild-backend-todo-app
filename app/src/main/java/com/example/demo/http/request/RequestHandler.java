package com.example.demo.http.request;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.InputStream;

public class RequestHandler {

    private final HttpExchange exchange;

    public RequestHandler(HttpExchange exchange) {
        this.exchange = exchange;
    }

    public String getRequestContent() throws IOException {
        InputStream inputStream = this.exchange.getRequestBody();
        return new String(inputStream.readAllBytes());
    }

    public String getRequestMethod() {
        return this.exchange.getRequestMethod();
    }

    public String getRequestURI() {
        return this.exchange.getRequestURI().getPath();
    }
}

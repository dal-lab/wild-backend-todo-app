package com.example.demo.http;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class RequestUri extends Request {

    public RequestUri(HttpExchange exchange) {
        super(exchange);
    }

    @Override
    public String handleRequest() throws IOException {
        return this.exchange.getRequestURI().getPath();
    }
}

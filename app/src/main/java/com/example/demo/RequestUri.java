package com.example.demo;

import com.sun.net.httpserver.HttpExchange;

public class RequestUri {

    private final HttpExchange exchange;

    public RequestUri(HttpExchange exchange) {
        this.exchange = exchange;
    }

    public String getRequestUri() {
        return this.exchange.getRequestURI().getPath();
    }

}

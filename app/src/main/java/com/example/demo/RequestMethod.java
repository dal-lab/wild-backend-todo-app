package com.example.demo;

import com.sun.net.httpserver.HttpExchange;

public class RequestMethod {

    public RequestMethod(HttpExchange exchange) {
        this.exchange = exchange;
    }

    private final HttpExchange exchange;


    public String getRequestMethod() {
        return this.exchange.getRequestMethod();
    }
}

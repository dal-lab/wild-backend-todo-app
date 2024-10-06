package com.example.demo;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public abstract class Request {

    protected final HttpExchange exchange;

    public Request(HttpExchange exchange) {
        this.exchange = exchange;
    }

    public abstract String handleRequest() throws IOException;

}

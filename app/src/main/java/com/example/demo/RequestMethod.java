package com.example.demo;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class RequestMethod extends Request {

    public RequestMethod(HttpExchange exchange) {
        super(exchange);
    }

    @Override
    public String handleRequest() throws IOException {
        return this.exchange.getRequestMethod();
    }
}

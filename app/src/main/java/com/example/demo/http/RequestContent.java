package com.example.demo.http;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.InputStream;

public class RequestContent extends Request {

    public RequestContent(HttpExchange exchange) {
        super(exchange);
    }

    @Override
    public String handleRequest() throws IOException {
        InputStream inputStream = this.exchange.getRequestBody();
        return new String(inputStream.readAllBytes());
    }
}

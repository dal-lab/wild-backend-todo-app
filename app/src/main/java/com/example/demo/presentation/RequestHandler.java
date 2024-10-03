package com.example.demo.presentation;

import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class RequestHandler implements HttpHandler {
    @Override
    public void handle(com.sun.net.httpserver.HttpExchange exchange) throws IOException {
        System.out.println("Hello, world!");
        byte[] responseBytes = "Hello, world!".getBytes();
        exchange.getResponseHeaders().set("Content-Type", "text/plain");
        exchange.sendResponseHeaders(200, responseBytes.length);
        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(responseBytes);
        }
        exchange.close();
    }
}

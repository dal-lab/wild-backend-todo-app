package com.example.demo;

import com.example.demo.controller.CreateTaskResource;
import com.example.demo.controller.HomeResource;
import com.example.demo.controller.ListTaskResource;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.InputStream;

public class RequestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestContent = getRequestContent(exchange);

        String requestMethod = getRequestMethod(exchange);
        String requestUri = getRequestUri(exchange);

        String responseContent = getResponseContent(requestMethod, requestUri,
                requestContent);

        if (responseContent == null) {
            exchange.sendResponseHeaders(404, -1);
        }

        sendResponse(exchange, responseContent);
    }

    public String getRequestContent(HttpExchange exchange) throws IOException {
        InputStream inputStream = exchange.getRequestBody();
        return new String(inputStream.readAllBytes());
    }

    public String getRequestMethod(HttpExchange exchange) {
        return exchange.getRequestMethod();
    }

    public String getRequestUri(HttpExchange exchange) {
        return exchange.getRequestURI().getPath();
    }

    public String getResponseContent(String requestMethod, String requestUri,
            String requestContent) throws IOException {
        if (requestMethod.contains("GET") && requestUri.equals("/")) {
            return new HomeResource().handler(requestContent);
        }

        if (requestMethod.contains("GET") && requestUri.equals("/tasks")) {
            return new ListTaskResource().handler(requestContent);
        }

        if (requestMethod.contains("POST") && requestUri.equals("/tasks")) {
            return new CreateTaskResource().handler(requestContent);
        }

        return null;
    }

    public void sendResponse(HttpExchange exchange, String responseContent)
            throws IOException {
        byte[] bytes = responseContent.getBytes();

        exchange.sendResponseHeaders(200, bytes.length);
        exchange.getResponseBody().write(bytes);
    }
}

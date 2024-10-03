package com.example.demo;

import com.example.demo.controller.CreateTaskResource;
import com.example.demo.controller.HomeResource;
import com.example.demo.controller.ListTaskResource;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler implements HttpHandler {

    Map<String, RequestMethodHandler> handlers = new HashMap<>();

    public RequestHandler() {
        handlers.put(HomeResource.KEY, new HomeResource());
        handlers.put(CreateTaskResource.KEY, new CreateTaskResource());
        handlers.put(ListTaskResource.KEY, new ListTaskResource());
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestContent = getRequestContent(exchange);

        String requestKey = getRequestKey(exchange);
        if (!handlers.containsKey(requestKey)) {
            exchange.sendResponseHeaders(404, -1);
        }

        String responseContent = getResponseContent(requestKey, requestContent);

        sendResponse(exchange, responseContent);
    }

    public String getRequestContent(HttpExchange exchange) throws IOException {
        InputStream inputStream = exchange.getRequestBody();
        return new String(inputStream.readAllBytes());
    }

    public String getRequestKey(HttpExchange exchange) {
        String requestMethod = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();

        return requestMethod + " " + path;
    }

    public String getResponseContent(String requestKey, String requestContent)
            throws IOException {
        RequestMethodHandler requestMethodHandler = handlers.get(requestKey);
        String responseContent = requestMethodHandler.handler(requestContent);
        return responseContent;
    }

    public void sendResponse(HttpExchange exchange, String responseContent)
            throws IOException {
        byte[] bytes = responseContent.getBytes();

        exchange.sendResponseHeaders(200, bytes.length);
        exchange.getResponseBody().write(bytes);
    }
}

package com.example.demo.presentation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler implements HttpHandler {

    private final TaskCreateHandler taskCreateHandler = new TaskCreateHandler();
    private final TaskGetHandler taskGetHandler = new TaskGetHandler();

    Map<String, ResourceMethodHandler> handlers = new HashMap<>();

    public RequestHandler() {
        handlers.put(TaskCreateHandler.KEY, taskCreateHandler);
        handlers.put(TaskGetHandler.KEY, taskGetHandler);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        ResourceMethodHandler handler = getResourceMethodHandler(exchange);
        if (handlerIsNull(exchange, handler)) return;

        String requestContent = getRequestContent(exchange);

        String responseContent = handler.handle(requestContent);

        sendResponseContent(exchange, responseContent);
    }

    private ResourceMethodHandler getResourceMethodHandler(HttpExchange exchange) {
        String key = getHandlerKey(exchange);
        ResourceMethodHandler handler = handlers.get(key);
        return handler;
    }

    private boolean handlerIsNull(HttpExchange exchange, ResourceMethodHandler handler) throws IOException {
        if (handler == null) {
            exchange.sendResponseHeaders(404, -1);
            return true;
        }
        return false;
    }

    private void sendResponseContent(HttpExchange exchange, String responseContent) throws IOException {
        byte[] bytes = responseContent.getBytes();
        exchange.sendResponseHeaders(200, bytes.length);
        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(bytes);
        }
    }

    private String getRequestContent(HttpExchange exchange) throws IOException {
        InputStream inputStream = exchange.getRequestBody();
        String requestContent = new String(inputStream.readAllBytes());
        return requestContent;
    }

    private String getHandlerKey(HttpExchange exchange) {
        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();
        String key = method + " " + path;
        return key;
    }
}

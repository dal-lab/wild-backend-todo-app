package com.example.demo.presentation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.HashMap;

public class RequestHandler implements HttpHandler {
    private final Map<String, ResourceMethodHandler> methodHandlers = new HashMap<>();

    public RequestHandler() {
        methodHandlers.put(TodoListReadResource.KEY, new TodoListReadResource());
        methodHandlers.put(TodoCreateResource.KEY, new TodoCreateResource());
        methodHandlers.put(TodoDeleteResource.KEY, new TodoDeleteResource());
        methodHandlers.put(TodoUpdateResource.KEY, new TodoUpdateResource());
    }

    @Override
    public void handle(com.sun.net.httpserver.HttpExchange exchange) throws IOException {
        String responseContent = "";
        try {
            String requestKey = getRequestKey(exchange);
            Integer paramId = getRequestId(exchange);
            if (!methodHandlers.containsKey(requestKey)) {
                responseContent = "methodHandlers에 " + requestKey + "가 없습니다.";
                throw new Exception(responseContent);
            }

            ResourceMethodHandler methodHandler = methodHandlers.get(requestKey);
            String requestContent = getRequestContent(exchange);
            responseContent = methodHandler.handle(requestContent, paramId);

        } catch (Exception e) {
            responseContent = e.getMessage();
        }

        byte[] responseContentBytes = responseContent.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(200, responseContentBytes.length);
        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(responseContentBytes);
        }
    }

    private Integer getRequestId(HttpExchange exchange) {
        String path = exchange.getRequestURI().getPath();
        if (path.startsWith("/todos/")) {
            String[] pathParts = path.split("/todos/");
            return Integer.parseInt(pathParts[pathParts.length - 1]);
        } else {
            return null;
        }
    }

    private String getRequestContent(HttpExchange exchange) throws IOException {
        try (InputStream inputStream = exchange.getRequestBody()) {
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString(StandardCharsets.UTF_8);
        }
    }

    private String getRequestKey(HttpExchange exchange) {
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();
        if (path.startsWith("/todos/")) {
            return method + " " + "/todos";
        }
        return method + " " + path;
    }
}

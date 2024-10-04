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
    private static final String TODOS_PATH = "/todos";

    public RequestHandler() {
        methodHandlers.put(TodoListReadResource.KEY, new TodoListReadResource());
        methodHandlers.put(TodoCreateResource.KEY, new TodoCreateResource());
        methodHandlers.put(TodoDeleteResource.KEY, new TodoDeleteResource());
        methodHandlers.put(TodoUpdateResource.KEY, new TodoUpdateResource());
    }

    @Override
    public void handle(com.sun.net.httpserver.HttpExchange exchange) throws IOException {
        String responseContent = "";
        ResourceMethodHandler methodHandler = null;
        try {
            String requestKey = getRequestKey(exchange);
            Integer paramId = getRequestId(exchange);
            if (!methodHandlers.containsKey(requestKey)) {
                responseContent = "methodHandlers에 " + requestKey + "가 없습니다.";
                throw new Exception(responseContent);
            }

            methodHandler = methodHandlers.get(requestKey);
            String requestContent = getRequestContent(exchange);
            responseContent = methodHandler.handle(requestContent, paramId);

        } catch (Exception e) {
            responseContent = e.getMessage();
        }

        byte[] responseContentBytes = responseContent.getBytes(StandardCharsets.UTF_8);
        assert methodHandler != null;
        exchange.sendResponseHeaders(methodHandler.getStatusCode(), responseContentBytes.length);
        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(responseContentBytes);
        }
    }

    private Integer getRequestId(HttpExchange exchange) {
        String path = exchange.getRequestURI().getPath();
        if (!path.startsWith("/todos/")) {
            return null;
        }

        String idStr = path.substring("/todos/".length());
        if (idStr.matches("\\d+")) {
            return Integer.parseInt(idStr);
        } else {
            System.out.printf("Invalid ID format: %s%n", idStr);
            return null;
        }
    }

    private static final int MAX_REQUEST_SIZE = 1024 * 1024; // 1MB

    private String getRequestContent(HttpExchange exchange) throws IOException {
        int contentLength = Integer.parseInt(exchange.getRequestHeaders().getFirst("Content-Length"));
        if (contentLength > MAX_REQUEST_SIZE) {
            throw new IllegalArgumentException("요청 본문이 너무 큽니다.");
        }
        byte[] content = new byte[contentLength];
        try (InputStream inputStream = exchange.getRequestBody()) {
            inputStream.readNBytes(content, 0, contentLength);
            return new String(content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IOException("요청 본문을 읽는 중 오류가 발생했습니다", e);
        }
    }

    private String getRequestKey(HttpExchange exchange) {
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();
        String normalizedPath = normalizePath(path);
        return method + " " + normalizedPath;
    }

    private String normalizePath(String path) {
        if (path.startsWith(TODOS_PATH + "/")) {
            return TODOS_PATH;
        }
        return path;
    }

}

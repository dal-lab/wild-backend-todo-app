package com.example.demo;

import com.example.demo.controller.CreateTaskResource;
import com.example.demo.controller.FindTaskResource;
import com.example.demo.controller.HomeResource;
import com.example.demo.controller.ListTaskResource;
import com.example.demo.controller.RemoveTaskResource;
import com.example.demo.controller.UpdateTaskResource;
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
            new ResponseNotFound(exchange).send(null);
        }

        new ResponseSuccess(exchange).send(responseContent);
    }

    private String getRequestContent(HttpExchange exchange) throws IOException {
        InputStream inputStream = exchange.getRequestBody();
        return new String(inputStream.readAllBytes());
    }

    private String getRequestMethod(HttpExchange exchange) {
        return exchange.getRequestMethod();
    }

    private String getRequestUri(HttpExchange exchange) {
        return exchange.getRequestURI().getPath();
    }

    private String getResponseContent(String requestMethod, String requestUri,
            String requestContent) throws IOException {
        if (requestMethod.equals("GET") && requestUri.equals("/")) {
            return new HomeResource().handler();
        }

        if (requestMethod.equals("POST") && requestUri.equals("/tasks")) {
            return new CreateTaskResource().handler(requestContent);
        }

        if (requestMethod.equals("GET") && requestUri.equals("/tasks")) {
            return new ListTaskResource().handler();
        }

        if (requestMethod.equals("GET") && requestUri.startsWith("/tasks/")) {
            Long taskId = getPathId(requestUri);
            return new FindTaskResource().handler(taskId);
        }

        if (requestMethod.equals("PATCH") && requestUri.startsWith("/tasks/")) {
            Long taskId = getPathId(requestUri);
            return new UpdateTaskResource().handler(taskId, requestContent);
        }

        if (requestMethod.equals("DELETE") && requestUri.startsWith(
                "/tasks/")) {
            Long taskId = getPathId(requestUri);
            return new RemoveTaskResource().handler(taskId);
        }

        return null;
    }

    private Long getPathId(String requestUri) {
        Long taskId = Long.parseLong(requestUri.substring("/tasks/".length()));
        return taskId;
    }
}

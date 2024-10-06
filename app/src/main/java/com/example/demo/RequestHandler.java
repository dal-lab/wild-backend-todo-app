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

public class RequestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestContent = new RequestContent(
                exchange).getRequestContent();

        String requestMethod = new RequestMethod(exchange).getRequestMethod();
        String requestUri = getRequestUri(exchange);

        String responseContent = getResponseContent(requestMethod, requestUri,
                requestContent);

        if (responseContent == null) {
            new ResponseNotFound(exchange).send(null);
        }

        new ResponseSuccess(exchange).send(responseContent);
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
            Long taskId = new TaskPathId().getPathId(requestUri);
            return new FindTaskResource().handler(taskId);
        }

        if (requestMethod.equals("PATCH") && requestUri.startsWith("/tasks/")) {
            Long taskId = new TaskPathId().getPathId(requestUri);
            return new UpdateTaskResource().handler(taskId, requestContent);
        }

        if (requestMethod.equals("DELETE") && requestUri.startsWith(
                "/tasks/")) {
            Long taskId = new TaskPathId().getPathId(requestUri);
            return new RemoveTaskResource().handler(taskId);
        }

        return null;
    }
}

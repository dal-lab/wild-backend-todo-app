package com.example.demo.presentation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Deprecated
@Component
public class RequestHandler implements HttpHandler {
    private final DefaultHandler defaultHandler;
    //new 없애기
    private final Map<String, TodoItemsHandler> handlers = new HashMap<>();
    public RequestHandler(TodoItemsSaveHandler todoItemsSaveHandler, TodoItemsGetHandler todoItemsGetHandler, DefaultHandler defaultHandler) {
        this.defaultHandler = defaultHandler;
        addHandler(todoItemsSaveHandler);
        addHandler(todoItemsGetHandler);
        addHandler(defaultHandler);
    }

    private void addHandler(TodoItemsHandler todoItemsHandler) {
        this.handlers.put(todoItemsHandler.getKey(), todoItemsHandler);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        //POST /todoItems, GET /todoItems 구분 필요
        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();

        //reqeust uri 분석해서 어떤 resourceHandler가 처리해야하는지 판정
        String key = method + " " + path;
        if(!this.handlers.containsKey(key)) {
            key = defaultHandler.getKey();
        }

        TodoItemsHandler handler = this.handlers.get(key);
        //byte -> string(json) -> dto
        String content = handler.handle(new String(exchange.getRequestBody().readAllBytes()));
        byte[] bytes = content.getBytes();

        exchange.sendResponseHeaders(200, bytes.length);
        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(bytes);
        responseBody.close();
    }
}

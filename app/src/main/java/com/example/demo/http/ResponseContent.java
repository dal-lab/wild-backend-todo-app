package com.example.demo.http;

import com.example.demo.http.content.CreateTaskRequestHandler;
import com.example.demo.http.content.FindTaskRequestHandler;
import com.example.demo.http.content.HomeRequestHandler;
import com.example.demo.http.content.ListTaskRequestHandler;
import com.example.demo.http.content.RemoveTaskRequestHandler;
import com.example.demo.http.content.RequestHandlerStrategy;
import com.example.demo.http.content.UpdateTaskRequestHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResponseContent {

    private final List<RequestHandlerStrategy> handlers = new ArrayList<>();

    public ResponseContent() {
        handlers.add(new HomeRequestHandler());
        handlers.add(new CreateTaskRequestHandler());
        handlers.add(new ListTaskRequestHandler());
        handlers.add(new FindTaskRequestHandler());
        handlers.add(new UpdateTaskRequestHandler());
        handlers.add(new RemoveTaskRequestHandler());
    }

    public String getResponseContent(RequestHandler requestHandler)
            throws IOException {
        RequestAttribute requestAttribute = new RequestBody().getRequestBody(
                requestHandler);

        for (RequestHandlerStrategy handler : handlers) {
            if (handler.matches(requestAttribute)) {
                return handler.handle(requestAttribute);
            }
        }

        return null;
    }
}

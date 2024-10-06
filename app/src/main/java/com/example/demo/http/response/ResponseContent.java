package com.example.demo.http.response;

import com.example.demo.http.request.RequestAttribute;
import com.example.demo.http.request.RequestBody;
import com.example.demo.http.request.RequestHandler;
import com.example.demo.http.requestContent.CreateTaskRequestHandler;
import com.example.demo.http.requestContent.FindTaskRequestHandler;
import com.example.demo.http.requestContent.HomeRequestHandler;
import com.example.demo.http.requestContent.ListTaskRequestHandler;
import com.example.demo.http.requestContent.RemoveTaskRequestHandler;
import com.example.demo.http.requestContent.RequestHandlerStrategy;
import com.example.demo.http.requestContent.UpdateTaskRequestHandler;
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

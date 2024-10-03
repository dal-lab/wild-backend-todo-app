package com.example.demo.http;

import com.example.demo.http.request.RequestHandler;
import com.example.demo.http.response.ResponseContent;
import com.example.demo.http.response.ResponseHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;

public class RequestResponseHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        RequestHandler requestHandler = new RequestHandler(exchange);

        String responseContent = new ResponseContent().getResponseContent(
                requestHandler);

        new ResponseHandler(exchange).send(responseContent);

    }
}

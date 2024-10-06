package com.example.demo;

import com.example.demo.http.RequestContent;
import com.example.demo.http.RequestMethod;
import com.example.demo.http.RequestUri;
import com.example.demo.http.ResponseContent;
import com.example.demo.http.ResponseNotFound;
import com.example.demo.http.ResponseSuccess;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;

public class RequestResponseHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestContent = new RequestContent(
                exchange).handleRequest();
        String requestMethod = new RequestMethod(exchange).handleRequest();
        String requestUri = new RequestUri(exchange).handleRequest();

        String responseContent = new ResponseContent().getResponseContent(
                requestMethod, requestUri, requestContent);

        if (responseContent == null) {
            new ResponseNotFound(exchange).send(null);
        }

        new ResponseSuccess(exchange).send(responseContent);
    }
}

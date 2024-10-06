package com.example.demo.http.response;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class ResponseHandler {

    private final HttpExchange exchange;

    public ResponseHandler(HttpExchange exchange) {
        this.exchange = exchange;
    }

    public void send(String responseContent) throws IOException {
        if (responseContent == null) {
            new ResponseNotFound(this.exchange).send(null);
        }

        new ResponseSuccess(this.exchange).send(responseContent);
    }
}

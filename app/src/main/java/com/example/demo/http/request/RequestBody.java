package com.example.demo.http.request;

import java.io.IOException;

public class RequestBody {

    public RequestAttribute getRequestBody(
        RequestHandler requestHandler)
        throws IOException {

        return new RequestAttribute(
            requestHandler.getRequestContent(),
            requestHandler.getRequestMethod(),
            requestHandler.getRequestURI()
        );
    }
}

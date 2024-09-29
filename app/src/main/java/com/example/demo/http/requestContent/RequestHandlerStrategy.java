package com.example.demo.http.requestContent;

import com.example.demo.http.request.RequestAttribute;
import java.io.IOException;

public interface RequestHandlerStrategy {
    boolean matches(RequestAttribute requestAttribute);
    String handle(RequestAttribute requestAttribute) throws IOException;
}

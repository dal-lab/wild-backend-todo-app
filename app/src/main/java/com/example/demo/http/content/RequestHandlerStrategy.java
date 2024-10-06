package com.example.demo.http.content;

import com.example.demo.http.RequestAttribute;
import java.io.IOException;

public interface RequestHandlerStrategy {
    boolean matches(RequestAttribute requestAttribute);
    String handle(RequestAttribute requestAttribute) throws IOException;
}

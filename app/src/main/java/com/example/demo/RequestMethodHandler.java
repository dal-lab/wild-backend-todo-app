package com.example.demo;

import java.io.IOException;

public interface RequestMethodHandler {

    String handler(String content) throws IOException;
}

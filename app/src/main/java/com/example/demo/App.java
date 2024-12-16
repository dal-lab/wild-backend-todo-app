package com.example.demo;

import com.example.demo.presentation.RequestHandler;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {
        App app = new App();
        app.run();
    }

    private void run() throws IOException {
        System.out.println("TODO app, Server starts");

        HttpHandler requestHandler = new RequestHandler();

        InetSocketAddress address = new InetSocketAddress(
                "localhost", 8080
        );

        HttpServer server = HttpServer.create(address, 0);

        server.createContext("/", requestHandler);
        server.start();

        System.out.println("Listening on http://localhost:8080");
    }
}

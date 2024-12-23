package com.example.demo;

import com.example.demo.presentation.RequestHandler;
import com.sun.net.httpserver.HttpServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;

@Deprecated
@Component
public class Server {
    private final RequestHandler requestHandler;

    //생성자 주입
    public Server(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void run() throws IOException {
        //new 없애기
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8080), -1); //주소, backlog -1 설정
        httpServer.createContext("/", requestHandler);

        httpServer.start();


        System.out.println("server listening~~");
    }
}

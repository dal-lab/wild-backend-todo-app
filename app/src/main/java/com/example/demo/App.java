package com.example.demo;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class App {

    /*
        spring 기본
        curl -i -X POST -d '{"seq": 1, "item": "study wildbackend100", "isDone": false}' localhost:8080/todoItems
        curl -i -X GET localhost:8080/todoItems
        curl -i -X GET localhost:8080/test

        web mvc
        curl -i -X GET localhost:8080/todoItems
        curl -i -X POST -d '{"seq": 2, "item": "study wildbackend100", "isDone": false}' -H 'Content-Type:application/json' localhost:8080/todoItems
    */

    public static void main(String[] args) throws IOException {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}

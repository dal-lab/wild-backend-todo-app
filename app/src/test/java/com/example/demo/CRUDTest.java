package com.example.demo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CRUDTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Replace with your API base URL
        RestAssured.defaultParser = io.restassured.parsing.Parser.JSON;
    }

    @Order(1)
    @Test
    public void testCreateTodo() {
        String newTodo = "{ \"title\": \"New Todo\"}";

        given()
                .header("Content-Type", "application/json")
                .body(newTodo)
                .when()
                .post("/todos")
                .then()
                .statusCode(201)
                .body("id", instanceOf(Number.class)) // Check if the ID is of type Number
                .body("title", equalTo("New Todo"))
                .body("isCompleted", equalTo(false));
    }

    @Order(2)
    @Test
    public void testGetTodos() {
        given()
                .when()
                .get("/todos")
                .then()
                .statusCode(200)
                .body("size()", equalTo(1)); // Adjust the expected size as per your data
    }

    @Order(3)
    @Test
    public void testUpdateTodo() {
        String updatedTodo = "{ \"title\": \"Updated Todo\", \"isCompleted\": true }";
        given()
                .header("Content-Type", "application/json")
                .body(updatedTodo)
                .when()
                .put("/todos/0") // Replace with an existing Todo ID
                .then()
                .statusCode(200)
                .body("title", equalTo("Updated Todo"))
                .body("isCompleted", equalTo(true));
    }

    @Order(4)
    @Test
    public void testDeleteTodo() {
        given()
                .when()
                .delete("/todos/0") // Replace with an existing Todo ID
                .then()
                .statusCode(204);

        given()
                .when()
                .delete("/todos/0")
                .then()
                .statusCode(404);
    }

    @AfterAll
    public static void initiate() {
//        delete all todos
        given()
                .when()
                .delete("/todos")
                .then()
                .statusCode(204);
    }
}

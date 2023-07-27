package com.studentapp.specificationexample;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Jay
 */
public class RequestSpecificationExample {



    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

    }

    @Test
    public void test001() {
        given().log().all()
                .header("Content-Type", "application/json")
                .queryParam("$limit", 2)
                .when()
                .get("/products")
                .then()
                .statusCode(200);
    }

    @Test
    public void test002() {
        given()
                .header("Content-Type", "application/json")
                .queryParam("$limit", 2)
                .when()
                .get("/products")
                .then()
                .statusCode(200);
    }


}

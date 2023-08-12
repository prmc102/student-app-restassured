package com.studentapp.specificationexample;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Jay
 */
public class RequestSpecificationExample {

    private static RequestSpecification requestSpecification;

    private static RequestSpecBuilder builder;



    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        builder = new RequestSpecBuilder();
        builder.addHeader("Content-Type", "application/json");
        builder.addQueryParam("$limit", 2);
        requestSpecification = builder.build();

    }

    @Test
    public void test001() {
        given().log().ifValidationFails()
                /*.header("Content-Type", "application/json")
                .queryParam("$limit", 2)*/
                .spec(requestSpecification)
                .when()
                .get("/products")
                .then().log().ifValidationFails()
                .statusCode(201);
    }

    @Test
    public void test002() {
        given()
                /*.header("Content-Type", "application/json")
                .queryParam("$limit", 2)*/
                .spec(requestSpecification)
                .when()
                .get("/products")
                .then()
                .statusCode(200);
    }


}

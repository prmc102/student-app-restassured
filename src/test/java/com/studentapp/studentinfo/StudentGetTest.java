package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStudentInfo() {
        Response response = given()
                .pathParam("id", 55)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchStudentWithParameter() {
        Map<String, Object> qParam = new HashMap<>();
        qParam.put("programme", "Computer Science");
        qParam.put("limit", 3);

        Response response = given()
                /*.queryParam("programme", "Computer Science")
                .queryParam("limit", 3)*/
                .queryParams(qParam)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}

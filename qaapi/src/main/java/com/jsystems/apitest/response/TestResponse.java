package com.jsystems.apitest.response;

import com.jsystems.apitest.models.MyObj;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestResponse{


    public static Response getResponse(RequestSpecification requestSpecification, String endpoint){
        Response response  = RestAssured
                .given()
                .contentType("application/json")
                .when()
                .spec(requestSpecification)
                .get(endpoint)
                .andReturn();

        return response;

    }

    public static Response postResponse(RequestSpecification requestSpecification, String endpoint, MyObj object){
        Response response  = RestAssured
                .given()
                .contentType("application/json")
                .when()
                .body(object)
                .spec(requestSpecification)
                .post(endpoint)
                .andReturn();

        return response;

    }

    public static Response getResponseFakeRestApiBook(RequestSpecification requestSpecificationFake, String endpoint, int id){
        return RestAssured
                .given()
                .contentType("application/json")
                .when()
                .spec(requestSpecificationFake)
                .get(endpoint, id)
                .andReturn();

    }
}

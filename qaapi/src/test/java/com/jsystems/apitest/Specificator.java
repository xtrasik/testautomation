package com.jsystems.apitest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class Specificator {
    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri("http://www.mocky.io/")
            .setBasePath("v2")
            .build();

    @BeforeEach
    public void before() {
        System.out.println("================== @BeforeClass RestTest JUpiter =====================");
    }

    @BeforeAll
    public static void setUp() {
        System.out.println("================== @BeforeAll RestTest JUpiter =====================");

//        RestAssured.baseURI = TestData.baseUri;
//        RestAssured.basePath = "/v2";

    }
}

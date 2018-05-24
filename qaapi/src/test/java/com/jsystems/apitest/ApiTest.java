package com.jsystems.apitest;



import com.jsystems.apitest.models.MyObj;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ApiTest extends Specificator {

    @Test
    @DisplayName("First REST api Test")
    public void apiFirstTest() {
        given()
                .when()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));

    }

    @Test
    @DisplayName("Second REST api Test")
    public void apiSecondTest() {
        JsonPath jsonPath = given()
                .when()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie", is("Piotr"))
                .body("[0].nazwisko", equalTo("Kowalski"))
                .body("[0].device[0].type", equalTo("computer"))
                //.body("[0].device[0].device.model[0].produce", equalTo("dell"))
                .extract()
                .body()
                .jsonPath();

//        MyObj myObj = jsonPath.getObject("", MyObj.class);
//
//        assertThat(myObj.name).isEqualTo("Piotr");
//        assertThat(myObj.surname).isEqualTo("Kowalski");

        System.out.println(jsonPath);
    }

    @Test
    @DisplayName("Third REST api Test with specificator")
    public void apiThirdTest() {
        JsonPath jsonPath = given()
                .when()
                .spec(requestSpecification)
                .get("/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

       MyObj person = jsonPath.getObject("", MyObj.class);

        assertTrue(person.name.equals("Piotr"));
        assertTrue(person.surname.equals("Kowalski"));

        System.out.println(person.toString());

    }

}


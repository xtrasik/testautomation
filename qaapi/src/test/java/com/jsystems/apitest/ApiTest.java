package com.jsystems.apitest;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ApiTest {

    @Test
    @DisplayName("First REST api Test")
    public void apiFirstTest() {
        RestAssured.given()
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
        JsonPath jsonPath = RestAssured.given()
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

}

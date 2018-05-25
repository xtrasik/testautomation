package com.jsystems.apitest;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsystems.apitest.models.MyObj;
import com.jsystems.apitest.models.TestUserGeneric;
import com.jsystems.apitest.models.User;
import com.jsystems.apitest.response.TestResponse;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiTest extends Specificator {

    @Test
    @DisplayName("1 - First REST api Test")
    public void a_apiFirstTest() {
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
    @DisplayName("2 - Second REST api Test")
    public void b_apiSecondTest() {
        JsonPath jsonPath = given()
                .when()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", is("Piotr"))
                .body("surname", equalTo("Kowalski"))
                //.body("[0].device[0].device.model[0].produce", equalTo("dell"))
                .extract()
                .body()
                .jsonPath();

        MyObj person = jsonPath.getObject("", MyObj.class);

        assertTrue(person.name.equals("Piotr"));
        assertTrue(person.surname.equals("Kowalski"));

        System.out.println(person.toString());

        System.out.println(jsonPath.prettyPrint());
    }

    @Test
    @DisplayName("3 - Third REST api Test with specificator and serializable object")
    public void c_apiThirdTest() {
        JsonPath jsonPath = given()
                .when()
                .spec(requestSpecification)
                .get("/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].device[0].type", equalTo("computer"))
                .extract()
                .body()
                .jsonPath();


        List <User> users = jsonPath.getList("", User.class);

        assertTrue((users.get(0).device.get(0).deviceModel.get(0).produce).equalsIgnoreCase("dell"));


        System.out.println(users.toString());
    }

    @Test
    @DisplayName("4 - Forth Tests Rest Assured + userModel")
    public void d_apiForthTest() {
        Response response = given()
                .spec(requestSpecification)
                .contentType("application/json")
                .when()
                .get("/5a6a58222e0000d0377a7789")
                .andReturn();

        User[] usersTab = response
                .then()
                .extract()
                .body()
                .as(User[].class);

        List<User> users = Arrays.asList(usersTab);

        System.out.println(users.get(0).toString());
        System.out.println(users.get(0).device.get(0).deviceModel.get(0).toString());

        assertTrue(response.contentType().equals("application/json"));
        assertTrue((users.get(0).device.get(0).type).equalsIgnoreCase("computer"));
        assertTrue((users.get(0).device.get(0).deviceModel.get(0).produce).equalsIgnoreCase("dell"));
        assertTrue((users.get(0).device.get(0).deviceModel.get(0).screen_size).equals("17"));
    }

    @Test
    @DisplayName("5 - Fifth Test Response w objekcie")
    public void e_apiFifthTest() {

        String link = "/5a6a58222e0000d0377a7789/";
        Response response = new TestResponse().getResponse(requestSpecification, link);

        User[] usersTab = response
                .then()
                .extract()
                .body()
                .as(User[].class);

        List<User> users = Arrays.asList(usersTab);

        System.out.println(users.get(0).toString());
        System.out.println(users.get(0).device.get(0).deviceModel.get(0).toString());

        assertTrue(response.contentType().equals("application/json"));
        assertTrue((users.get(0).device.get(0).type).equalsIgnoreCase("computer"));
        assertTrue((users.get(0).device.get(0).deviceModel.get(0).produce).equalsIgnoreCase("dell"));
        assertTrue((users.get(0).device.get(0).deviceModel.get(0).screen_size).equals("17"));
    }

    @Test
    @DisplayName("6 - Sixth Test na posta")
    public void f_apiSixthTest() {

        String link = "/5a690a1b2e000051007a73cb/";
        MyObj object = new MyObj("Rafal", "Wrobel");
        Response response = new TestResponse().postResponse(requestSpecification, link, object);

        String responsePost = Arrays.asList(response
                .then()
                .statusCode(201)
                .extract()
                .body()
                .as(String[].class)).toString();

        System.out.println(responsePost);

        assertTrue(responsePost.equals("[]"));
    }

    @Test
    @DisplayName("7 - Seventh Test for mapping response to the reference type ")
    public void g_apiSeventhTest() throws IOException {

        String link = "/5b05c83e3200009700ebfa2b";
        Response response = new TestResponse().getResponse(requestSpecification, link);

        TestUserGeneric<String> testUserGeneric = new ObjectMapper().readValue(
                response
                .then()
                .extract()
                .body()
                .asInputStream(), new TypeReference<TestUserGeneric<String>>(){});

        System.out.println(testUserGeneric);
    }

    @Test
    @DisplayName("8 - Test na JsonSchema majac przykladowego JSONa")
    public void h_apiEighthTest() {

        String link = "/5a690b452e000054007a73cd";
        Response response = new TestResponse().getResponse(requestSpecification, link);

        response
                .then()
                .assertThat()
                .body(matchesJsonSchema(new File("src/test/resources/validation.json")));
    }

    @Test
    @DisplayName("9 - Test na JsonSchema majac JSON schema")
    public void i_apiNinethTest() {
        String link = "/5a6a58222e0000d0377a7789";
        Response response = new TestResponse().getResponse(requestSpecification, link);

        response
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("Validator.json"));
    }

}


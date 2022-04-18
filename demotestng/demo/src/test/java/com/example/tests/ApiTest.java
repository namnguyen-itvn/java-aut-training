package com.example.tests;

import com.example.core.helper.RestAssuredHelper;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiTest extends ApiBaseTest {
    @Test
    public void verifyTheStatusCodeResponse200() {
        res = RestAssuredHelper.getResponse("/gen/clients");
        demoAPITTest.checkStatusIs200(res);
    }

    @Test
    public void exampleJsonPathTest() {
        RestAssured.baseURI = "http://generator.swagger.io/";
        Response res = given().get("/gen/clients/android");
        assertEquals(200, res.getStatusCode());
    }

    @Test
    public void postExamplebyGherkin() {
        RestAssured.baseURI = "http://generator.swagger.io/";
        Response res = given()
                .contentType("application/json")
                .body("{\"name\":\"TestPostMessage\"}")
                .when()
                .post("");
        assertEquals(302, res.getStatusCode());
    }

    @Test
    public void getAndroidModelPackageOptions() {
        res = RestAssuredHelper.getResponse("/gen/clients/android");
        demoAPITTest.checkStatusIs200(res);
        jp = RestAssuredHelper.getJsonPath(res);
        System.out.println("Opt: " + jp.get("modelPackage.opt"));
        System.out.println("Description: " + jp.get("modelPackage.description"));
        System.out.println("Type: " + jp.get("modelPackage.type"));
    }
}

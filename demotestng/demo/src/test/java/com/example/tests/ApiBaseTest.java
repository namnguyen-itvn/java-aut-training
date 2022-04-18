package com.example.tests;

import com.example.pages.ApiDemoPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.example.core.helper.RestAssuredHelper;


public class ApiBaseTest {
    public Response res = null;
    public JsonPath jp = null;

    ApiDemoPage demoAPITTest = new ApiDemoPage();

    @BeforeMethod
    public void setup() {
        // Test Setup
        RestAssuredHelper.setBaseURI();
        RestAssuredHelper.setBasePath("api");
        RestAssuredHelper.setContentType(ContentType.JSON);
    }

    @AfterMethod
    public void afterTest() {
        // Reset Values
        RestAssuredHelper.resetBaseURI();
        RestAssuredHelper.resetBasePath();
    }
}

package com.example.pages;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.ArrayList;
import org.testng.Assert;

public class ApiDemoPage {
    public void checkStatusIs200(Response res) {
        Assert.assertEquals(res.getStatusCode(), 200, "Status Check Failed!");
    }

    // Get Clients
    public <T> ArrayList<T> getClients(JsonPath jp) {
        return jp.get();
    }
}

package com.saveatrain.saveatraincomplexapi.test;

import com.saveatrain.saveatraincomplexapi.test.serialising.SalesAgentSessionPOJO;
import com.saveatrain.utils.GetPropertyValues;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ServiceHelper {

    GetPropertyValues getPropertyValues = new GetPropertyValues();
    private final String LOGIN = getPropertyValues.getPropValue("login");
    private final String PASSWD = getPropertyValues.getPropValue("password");
    private final String BASE_URI = getPropertyValues.getPropValue("serverURL");

    public Response sendPostRequest(String endpoint) {

        SalesAgentSessionPOJO body = new SalesAgentSessionPOJO(LOGIN, PASSWD);
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = BASE_URI;

        RequestSpecification requestSpec = RestAssured.with()
                .contentType("application/json")
                .baseUri(BASE_URI)
                .body(body);
                //.log().all();

        return requestSpec
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
}

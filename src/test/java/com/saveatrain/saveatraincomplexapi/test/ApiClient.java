package com.saveatrain.saveatraincomplexapi.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ApiClient {

    private final String baseUri;

    public ApiClient(String baseUri) {
        this.baseUri = baseUri;
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = baseUri;
    }

    public Response sendPostRequest(String endpoint, Object body, Map<String, String> headers) {
        RequestSpecification requestSpec = RestAssured
                .given()
                .contentType("application/json")
                .baseUri(baseUri)
                .headers(headers)
                .body(body);

        return requestSpec
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response sendPostRequest(String endpoint, Object body) {
        return sendPostRequest(endpoint, body, Map.of());
    }
}

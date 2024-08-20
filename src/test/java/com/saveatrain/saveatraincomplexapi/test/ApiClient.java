package com.saveatrain.saveatraincomplexapi.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class ApiClient {

    private final String baseUri;

    public ApiClient(String baseUri) {
        this.baseUri = baseUri;
        RestAssured.baseURI = baseUri;
    }

    public Response sendPostRequest(String endpoint, Object body, Map<String, String> headers) {
        return RestAssured.given()
                .headers(headers)
                .contentType("application/json")
                .body(body)
                .post(endpoint);
    }

    public Response sendPostRequest(String endpoint, Object body) {
        return RestAssured.given()
                .contentType("application/json")
                .body(body)
                .post(endpoint);
    }
}

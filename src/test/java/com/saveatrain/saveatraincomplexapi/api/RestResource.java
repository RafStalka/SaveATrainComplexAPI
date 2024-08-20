package com.saveatrain.saveatraincomplexapi.api;

import io.restassured.response.Response;

import static com.saveatrain.saveatraincomplexapi.api.ApiClient.getRequestSpec;
import static com.saveatrain.saveatraincomplexapi.api.ApiClient.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response postRequest(String endpoint, Object searchApi) {
        return given(getRequestSpec()).
                body(searchApi).
                when().post(endpoint).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response getRequest(String endpoint, String token, String email, String searchId) {
        return given(getRequestSpec()).
                header("X-Agent-Email", email).
                header("X-Agent-Token", token).
                when().get(endpoint + "/" + searchId).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

}

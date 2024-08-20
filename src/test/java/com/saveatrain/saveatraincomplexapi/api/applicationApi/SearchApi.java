package com.saveatrain.saveatraincomplexapi.api.applicationApi;

import com.saveatrain.saveatraincomplexapi.serialising.SalesAgentSessionPOJO;
import com.saveatrain.utils.GetPropertyValues;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

import static com.saveatrain.saveatraincomplexapi.api.ApiClient.getRequestSpec;
import static com.saveatrain.saveatraincomplexapi.api.ApiClient.getResponseSpec;
import static io.restassured.RestAssured.given;

public class SearchApi {

    public static Response postRequest(SalesAgentSessionPOJO session) {
        String url = GetPropertyValues.getProperty("serverURL") + "/api/sales_agent_sessions";
        return RestAssured.given()
                .baseUri(url)
                .contentType("application/json")
                .body(session)
                .when()
                .post();
    }

    public Response sendPostRequest(String endpoint, String requestBody, Map<String, String> headers) {
        String baseUrl = GetPropertyValues.getProperty("serverURL");
        return RestAssured.given()
                .baseUri(baseUrl)
                .headers(headers)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    public static Response getRequest(String endpoint, String searchId) {
        return given(getRequestSpec()).
                when().get(endpoint + "/" + searchId).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

}

package com.saveatrain.saveatraincomplexapi.api;

import com.saveatrain.saveatraincomplexapi.serialising.SalesAgentSessionPOJO;
import com.saveatrain.utils.GetPropertyValues;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenManager {
    private static final String serverURL = GetPropertyValues.getProperty("serverURL");

    public static String getToken(SalesAgentSessionPOJO session) {
        String url = serverURL + "/api/sales_agent_sessions";

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(session)
                .post(url);

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to authenticate with the server. HTTP Status code: " + response.getStatusCode());
        }

        // Log the response for debugging
        System.out.println("Response: " + response.asString());

        return response.jsonPath().getString("access_token");
    }
}

package com.saveatrain.saveatraincomplexapi.api.applicationApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saveatrain.saveatraincomplexapi.api.RestResource;
import com.saveatrain.saveatraincomplexapi.serialising.SalesAgentSessionPOJO;
import com.saveatrain.utils.GetPropertyValues;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;


public abstract class SearchApi extends RestResource {

    private static final String SALES_AGENT_ENDPOINT = GetPropertyValues.getProperty("base.path");

    public static Response postSalesAgentSession(SalesAgentSessionPOJO session) {
        String requestBody = sessionAsJson(session);
        return executePostRequest(SALES_AGENT_ENDPOINT, requestBody, new HashMap<>());
    }

    public Response sendPostRequest(String endpoint, String requestBody, Map<String, String> headers) {
        return executePostRequest(endpoint, requestBody, headers);
    }

    private static Response executePostRequest(String endpoint, String requestBody, Map<String, String> headers) {
        String baseUrl = GetPropertyValues.getProperty("serverURL");
        return RestAssured.given()
                .baseUri(baseUrl)
                .headers(headers)
                .contentType(GetPropertyValues.getProperty("content.type"))
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    private static String sessionAsJson(SalesAgentSessionPOJO session) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(session);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert session to JSON", e);
        }
    }
}

package com.saveatrain.saveatraincomplexapi.test;

import com.saveatrain.saveatraincomplexapi.api.TokenManager;
import com.saveatrain.saveatraincomplexapi.api.applicationApi.SearchApi;
import com.saveatrain.saveatraincomplexapi.serialising.SalesAgentSessionPOJO;
import com.saveatrain.utils.GetPropertyValues;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NSITest {
    private SalesAgentSessionPOJO loginDetails;
    private String token;

    @BeforeEach
    public void setUp() {
        loginDetails = new SalesAgentSessionPOJO(
                GetPropertyValues.getProperty("login"),
                GetPropertyValues.getProperty("password")
        );
        token = TokenManager.getToken(loginDetails);
        assertNotNull(token, "Token should be retrieved and not null");
    }

    @Test
    public void checkingAllLibrariesAreReadyTest() {
        assertThat(RestAssured.config(), instanceOf(RestAssuredConfig.class));
    }

    @Test
    public void testPostSalesAgentSession() {
        Response response = SearchApi.postSalesAgentSession(loginDetails);
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.jsonPath().getString("access_token"), "Access token should not be null");
    }

    @Test
    public void testSendPostRequestWithHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        headers.put("Custom-Header", "CustomValue");

        String endpoint = "/api/sales_agent_sessions";
        String requestBody = "{\"email\": \"" + loginDetails.getEmail() + "\", \"password\": \"" + loginDetails.getPassword() + "\"}";
        SearchApi searchApi = new SearchApi() {}; // Instantiate like this since SearchApi is abstract
        Response response = searchApi.sendPostRequest(endpoint, requestBody, headers);

        assertEquals(200, response.getStatusCode(), "Expected status code is 200");
    }

    @Test
    public void testSendPostRequestWithInvalidEndpoint() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        headers.put("Custom-Header", "CustomValue");

        String invalidEndpoint = "/api/invalid_endpoint";
        String requestBody = "{\"email\": \"" + loginDetails.getEmail() + "\", \"password\": \"" + loginDetails.getPassword() + "\"}";
        SearchApi searchApi = new SearchApi() {}; // Instantiate like this since SearchApi is abstract
        Response response = searchApi.sendPostRequest(invalidEndpoint, requestBody, headers);

        assertEquals(404, response.getStatusCode(), "Expected status code is 404 for invalid endpoint");
        System.out.println("Response: " + response.asString());
    }
}

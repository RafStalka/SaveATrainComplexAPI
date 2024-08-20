package com.saveatrain.saveatraincomplexapi.test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class NSITest {

    private static ServiceHelper serviceHelper;
    private static String token;

    @BeforeAll
    public static void setUp() {
        initializeServiceHelper();
        authenticateAndObtainToken();
    }

    private static void initializeServiceHelper() {
        serviceHelper = new ServiceHelper();
    }

    private static void authenticateAndObtainToken() {
        String endpoint = "/api/sales_agent_sessions";
        Response response = serviceHelper.sendPostRequest(endpoint);
        token = response.jsonPath().getString("access_token");

        assertNotNull(token, "Token should not be null");
    }

    @Test
    public void checkingAllLibrariesAreReadyTest() {
        assertThat(RestAssured.config(), instanceOf(RestAssuredConfig.class));
    }

    @Test
    public void testSendPostRequest() {
        Response response = serviceHelper.sendPostRequest("/api/sales_agent_sessions");
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void verifyTokenIsRetrievedInSetupTest() {
        assertNotNull(token, "Token should already have been obtained in setUp");
    }

    @Test
    public void testSendPostRequestWithHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        headers.put("Custom-Header", "CustomValue");

        String endpoint = "/api/sales_agent_sessions";
        Response response = serviceHelper.sendPostRequestWithHeaders(endpoint, headers);

        assertEquals(200, response.getStatusCode(), "Expected status code is 200");
    }

    @Test
    public void testSendPostRequestWithInvalidEndpoint() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        headers.put("Custom-Header", "CustomValue");

        String invalidEndpoint = "/api/invalid_endpoint";
        Response response = serviceHelper.sendPostRequestWithHeaders(invalidEndpoint, headers);

        assertEquals(404, response.getStatusCode(), "Expected status code is 404 for invalid endpoint");
        System.out.println("Response: " + response.asString());
    }


}

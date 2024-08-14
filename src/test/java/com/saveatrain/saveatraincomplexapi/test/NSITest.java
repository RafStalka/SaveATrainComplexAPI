package com.saveatrain.saveatraincomplexapi.test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        //System.out.println("Response: " + response.asString());
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

}

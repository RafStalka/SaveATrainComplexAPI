package com.saveatrain.saveatraincomplexapi.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saveatrain.saveatraincomplexapi.api.TokenManager;
import com.saveatrain.saveatraincomplexapi.api.applicationApi.SearchApi;
import com.saveatrain.saveatraincomplexapi.deserialising.SearchResponsePOJO;
import com.saveatrain.saveatraincomplexapi.serialising.*;
import com.saveatrain.utils.GetPropertyValues;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NSITest {
    private SalesAgentSessionPOJO loginDetails;
    private String token;
    private String baseUri;
    private String agentEmail;

    @BeforeEach
    public void setUp() {
        loginDetails = new SalesAgentSessionPOJO(
                GetPropertyValues.getProperty("login"),
                GetPropertyValues.getProperty("password")
        );
        token = TokenManager.getToken(loginDetails);
        assertNotNull(token, "Token should be retrieved and not null");
        baseUri = GetPropertyValues.getProperty("serverURL");
        agentEmail = GetPropertyValues.getProperty("login");

        // Print debug information
        System.out.println("Token: " + token);
        System.out.println("Base URI: " + baseUri);
        System.out.println("Agent Email: " + agentEmail);

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

    @Test
    public void testPostSearchSession() {
        RestAssured.baseURI = baseUri;

        if (token == null || agentEmail == null) {
            throw new IllegalArgumentException("Token or Agent Email is null. Please ensure these values are correctly set.");
        }

        // Create the request body using the POJO classes
        Search search = new Search();
        search.setDepartureDatetime("2024-08-24 07:00");

        _0 passenger = new _0();
        passenger.setAge(41);
        PassengerTypeAttributes passengerType = new PassengerTypeAttributes();
        passengerType.setType("Search::PassengerType::Adult");
        passenger.setPassengerTypeAttributes(passengerType);

        SearchesPassengersAttributes passengersAttributes = new SearchesPassengersAttributes();
        passengersAttributes.set0(passenger);
        search.setSearchesPassengersAttributes(passengersAttributes);

        RouteAttributes route = new RouteAttributes();
        OriginStationAttributes originStation = new OriginStationAttributes();
        originStation.setUid("SAT_DE_BE_EODMS");
        DestinationStationAttributes destinationStation = new DestinationStationAttributes();
        destinationStation.setUid("SAT_DE_HA_NJFMU");
        route.setOriginStationAttributes(originStation);
        route.setDestinationStationAttributes(destinationStation);
        search.setRouteAttributes(route);

        SearchPOJO searchRequest = new SearchPOJO();
        searchRequest.setSearch(search);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody;

        try {
            requestBody = objectMapper.writeValueAsString(searchRequest);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize request body", e);
        }

        Response response = given()
                .header("X-Agent-Email", agentEmail)
                .header("X-Agent-Token", token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/searches")
                .then()
                .extract().response();

        // Check if the response status code is 200
        assertEquals(200, response.getStatusCode());

        // Deserialize the response body to SearchResponsePOJO
        SearchResponsePOJO searchResponse;
        try {
            searchResponse = objectMapper.readValue(response.getBody().asString(), SearchResponsePOJO.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize response body", e);
        }

        assertNotNull(searchResponse);
        assertNotNull(searchResponse.getIdentifier());
    }
}

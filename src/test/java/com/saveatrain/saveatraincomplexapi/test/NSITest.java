package com.saveatrain.saveatraincomplexapi.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saveatrain.saveatraincomplexapi.api.TokenManager;
import com.saveatrain.saveatraincomplexapi.api.applicationApi.SearchApi;
import com.saveatrain.saveatraincomplexapi.deserialising.search.Result;
import com.saveatrain.saveatraincomplexapi.deserialising.search.SearchResponsePOJO;
import com.saveatrain.saveatraincomplexapi.serialising.search.*;
import com.saveatrain.utils.GetPropertyValues;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NSITest {
    private SalesAgentSessionPOJO loginDetails;
    private String token;
    private String baseUri;
    private String agentEmail;

    private static String identifier;
    private static List<Integer> resultIds;

    private static final String STORAGE_FILE = "test_storage.txt";

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
        SearchApi searchApi = new SearchApi() {
        }; // Instantiate like this since SearchApi is abstract
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
        SearchApi searchApi = new SearchApi() {
        }; // Instantiate like this since SearchApi is abstract
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

        assertEquals(200, response.getStatusCode());

        SearchResponsePOJO searchResponse;
        try {
            searchResponse = objectMapper.readValue(response.getBody().asString(), SearchResponsePOJO.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize response body", e);
        }

        assertNotNull(searchResponse);
        assertNotNull(searchResponse.getIdentifier());
    }

    @Test
    public void testPostSearchSession_MissingToken() {
        RestAssured.baseURI = baseUri;

        // Ustaw agentEmail, ale brak tokena
        if (agentEmail == null) {
            throw new IllegalArgumentException("Agent Email jest pusty. Upewnij się, że wartość ta jest poprawnie ustawiona.");
        }
        String missingToken = "";

        // Ciało żądania (taka sama logika jak w sukcesie)
        // ...

        Response response = given()
                .header("X-Agent-Email", agentEmail)
                .header("X-Agent-Token", missingToken)
                .contentType(ContentType.JSON)
                //.body(requestBody)
                .when()
                .post("/api/searches")
                .then()
                .statusCode(403) // Zakładamy status 403 Forbidden
                .extract().response();

        assertEquals("Invalid token or missing token", response.getBody().asString());
    }

    @Test
    public void testPostSearchSession_InvalidUid() {
        RestAssured.baseURI = baseUri;

        if (token == null || agentEmail == null) {
            throw new IllegalArgumentException("Token lub Agent Email są puste. Upewnij się, że wartości te są poprawnie ustawione.");
        }

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
        originStation.setUid("INVALID_UID");
        DestinationStationAttributes destinationStation = new DestinationStationAttributes();
        destinationStation.setUid("INVALID_UID");
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
            throw new RuntimeException("Nie udało się zserializować ciała żądania", e);
        }

        Response response = given()
                .header("X-Agent-Email", agentEmail)
                .header("X-Agent-Token", token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/searches")
                .then()
                .statusCode(400) // Zakładamy status 400 Bad Request
                .extract().response();

        assertEquals("Invalid station UID", response.getBody().asString());
    }

    @Test
    public void testPostSearchSession_Success() {
        RestAssured.baseURI = baseUri;

        if (token == null || agentEmail == null) {
            throw new IllegalArgumentException("Token lub Agent Email są puste. Upewnij się, że wartości te są poprawnie ustawione.");
        }

        assertTrue(token.length() >= 30, "Token jest zbyt krótki");

        assertTrue(token.matches("^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+$"), "Token ma nieprawidłowy wzorzec");

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
            throw new RuntimeException("Nie udało się zserializować ciała żądania", e);
        }

        Response response = given()
                .header("X-Agent-Email", agentEmail)
                .header("X-Agent-Token", token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/searches")
                .then()
                .statusCode(200)
                .extract().response();

        assertNotNull(response.getBody());

        SearchResponsePOJO searchResponse;
        try {
            searchResponse = objectMapper.readValue(response.getBody().asString(), SearchResponsePOJO.class);
        } catch (Exception e) {
            throw new RuntimeException("Nie udało się zde-serializować ciała odpowiedzi", e);
        }

        assertNotNull(searchResponse);
        assertNotNull(searchResponse.getIdentifier());
    }

    @Test
    public void testPostSearchSession_InvalidTokenPattern() {
        RestAssured.baseURI = baseUri;

        String invalidToken = "invalid!token!format";

        assertFalse(invalidToken.matches("^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+$"), "Token ma poprawny wzorzec, co jest nieoczekiwane");

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
            throw new RuntimeException("Nie udało się zserializować ciała żądania", e);
        }

        Response response = given()
                .header("X-Agent-Email", agentEmail)
                .header("X-Agent-Token", invalidToken)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/searches")
                .then()
                .statusCode(403) // Zakładamy status 403 Forbidden
                .extract().response();

        assertEquals("Invalid token or missing token", response.getBody().asString());
    }

    @Test
    public void testPostSearchSession_TokenTooShort() {
        RestAssured.baseURI = baseUri;

        String shortToken = "short.token";

        assertTrue(shortToken.length() < 30, "Token jest dłuższy niż oczekiwano, co jest nieoczekiwane");

        Search search = new Search();
        search.setDepartureDatetime("2024-09-24 07:00");

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
            throw new RuntimeException("Nie udało się zserializować ciała żądania", e);
        }

        Response response = given()
                .header("X-Agent-Email", agentEmail)
                .header("X-Agent-Token", shortToken)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/searches")
                .then()
                .statusCode(403) // Zakładamy status 403 Forbidden
                .extract().response();

        assertEquals("Invalid token or missing token", response.getBody().asString());
    }

    @Test
    @Order(1)
    public void testPostSearchSession_SaveResponseValues() {

        RestAssured.baseURI = baseUri;

        String shortToken = "short.token";

        assertTrue(shortToken.length() < 30, "Token jest dłuższy niż oczekiwano, co jest nieoczekiwane");

        Search search = new Search();
        search.setDepartureDatetime("2024-09-24 07:00");

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
            throw new RuntimeException("Nie udało się zserializować ciała żądania", e);
        }

        System.out.println("Request Body: " + requestBody);

        Response response = given()
                .header("X-Agent-Email", agentEmail)
                .header("X-Agent-Token", token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/searches")
                .then()
                .log().all() // Logs the response details
                .statusCode(200)
                .extract().response();

        System.out.println("Response Body: " + response.getBody().asString());

        assertNotNull(response.getBody());

        System.out.println("Response Body: " + response.getBody().asString());

        SearchResponsePOJO searchResponse;
        try {
            searchResponse = objectMapper.readValue(response.getBody().asString(), SearchResponsePOJO.class);
        } catch (Exception e) {
            throw new RuntimeException("Nie udało się zde-serializować ciała odpowiedzi", e);
        }

        assertNotNull(searchResponse);
        assertNotNull(searchResponse.getIdentifier());

        String identifier = searchResponse.getIdentifier();
        List<Integer> resultIds = new ArrayList<>();
        if (searchResponse.getResults() != null) {
            for (Result result : searchResponse.getResults()) {
                resultIds.add(result.getId());
            }
        }

        System.out.println("Identifier: " + identifier);
        System.out.println("Result IDs: " + resultIds);

        try (FileWriter writer = new FileWriter(STORAGE_FILE)) {
            writer.write(identifier + "\n");
            for (Integer resultId : resultIds) {
                writer.write(resultId + "\n");
            }
        } catch (Exception e) {
            throw new RuntimeException("Nie udało się zapisać wartości do pliku", e);
        }
    }

    @Test
    @Order(2)
    public void testUseSavedResponseValues() {
        RestAssured.baseURI = baseUri;

        String identifier = null;
        List<Integer> resultIds = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(STORAGE_FILE))) {
            identifier = reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                resultIds.add(Integer.parseInt(line));
            }
        } catch (Exception e) {
            throw new RuntimeException("Nie udało się odczytać wartości z pliku", e);
        }

        assertNotNull(identifier, "Identifier powinien być ustawiony");
        assertNotNull(resultIds, "Result IDs powinny być ustawione");
        assertFalse(resultIds.isEmpty(), "Lista Result IDs nie powinna być pusta");

        System.out.println("Identifier used in next test: " + identifier);
        System.out.println("Result IDs used in next test: " + resultIds);

        for (int resultId : resultIds) {
            String getRequestUrl = "/api/searches/" + identifier + "/results/" + resultId + "/sub_routes";

            System.out.println("Request URL: " + getRequestUrl);
            Response response = given()
                    .header("X-Agent-Email", agentEmail)
                    .header("X-Agent-Token", token)
                    .contentType(ContentType.JSON)
                    .when()
                    .get(getRequestUrl)
                    .then()
                    .log().all() // Logs the response details
                    .statusCode(200)
                    .extract().response();

            System.out.println("Response for result ID " + resultId + ": " + response.getBody().asString());
        }
    }
}


package com.saveatrain.saveatraincomplexapi.test;

import com.saveatrain.saveatraincomplexapi.test.serialising.SalesAgentSessionPOJO;
import com.saveatrain.utils.GetPropertyValues;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class ServiceHelper {
    private final ApiClient apiClient;
    private String baseUri;
    private String login;
    private String passwd;

    public ServiceHelper() {
        initializeProperties();
        apiClient = new ApiClient(baseUri);
    }

    private void initializeProperties() {
        GetPropertyValues properties = new GetPropertyValues();
        this.baseUri = properties.getProperty("serverURL");
        this.login = properties.getProperty("login");
        this.passwd = properties.getProperty("password");
    }

    public Response sendPostRequest(String endpoint) {
        SalesAgentSessionPOJO body = new SalesAgentSessionPOJO(login, passwd);
        return apiClient.sendPostRequest(endpoint, body);
    }

    public Response sendPostRequestWithHeaders(String endpoint, Map<String, String> headers) {System.out.println("Sending POST request to: " + baseUri + endpoint);
        SalesAgentSessionPOJO body = new SalesAgentSessionPOJO(login, passwd);

        System.out.println("Sending POST request to: " + baseUri + endpoint);
        System.out.println("Headers: " + headers.toString());
        System.out.println("Request Body: " + body);

        Response response = RestAssured.given()
                .headers(headers)
                .contentType("application/json")
                .body(body)
                .post(endpoint);

        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        return response;
    }
}

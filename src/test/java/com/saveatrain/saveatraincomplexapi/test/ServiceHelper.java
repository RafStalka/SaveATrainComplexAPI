package com.saveatrain.saveatraincomplexapi.test;

import com.saveatrain.saveatraincomplexapi.test.serialising.SalesAgentSessionPOJO;
import com.saveatrain.utils.GetPropertyValues;
import io.restassured.response.Response;

import java.util.Map;

public class ServiceHelper {
    private ApiClient apiClient;
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

    public Response sendPostRequestWithHeaders(String endpoint, Map<String, String> headers) {
        SalesAgentSessionPOJO body = new SalesAgentSessionPOJO(login, passwd);
        return apiClient.sendPostRequest(endpoint, body, headers);
    }
}

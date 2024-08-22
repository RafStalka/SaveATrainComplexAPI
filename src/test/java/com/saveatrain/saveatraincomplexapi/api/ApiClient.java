package com.saveatrain.saveatraincomplexapi.api;

import com.saveatrain.saveatraincomplexapi.api.applicationApi.SearchApi;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiClient extends SearchApi {

    public RequestSpecification getRequestSpec() {
        return super.getRequestSpec();
    }

    public ResponseSpecification getResponseSpec() {
        return super.getResponseSpec();
    }
}

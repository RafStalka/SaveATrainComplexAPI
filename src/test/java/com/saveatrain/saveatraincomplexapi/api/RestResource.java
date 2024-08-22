package com.saveatrain.saveatraincomplexapi.api;

import com.saveatrain.utils.GetPropertyValues;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public abstract class RestResource {

    private static final String BASE_URI = GetPropertyValues.getProperty("base.uri");
    private static final String BASE_PATH = GetPropertyValues.getProperty("base.path");
    private static final String CONTENT_TYPE = GetPropertyValues.getProperty("content.type");

    protected RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setBasePath(BASE_PATH).
                setContentType(CONTENT_TYPE).
                log(LogDetail.ALL).
                build();
    }

    protected ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).
                build();
    }

}

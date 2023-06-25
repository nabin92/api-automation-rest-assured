package org.ado.client;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;
import util.PropertyReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BaseClient {
    protected static final String pat = "sdyoc6ezt7qnswzzehmvqsmm7azvgk7c7dbl2mr2d7l5radfdokq";
    protected static final String baseUri = "https://dev.azure.com";
    protected String organization = "nabinghosh11";

    protected String project = "TestTribeMeetUp";
    PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();

    public RequestSpecification getRequestSpecificationsForCreateProject() {
        authScheme.setUserName("user");
        authScheme.setPassword(pat);

        return new RequestSpecBuilder().setBaseUri(baseUri)
                .addQueryParam("api-version", 7.0)
                .addPathParam("organization", organization)
                .addHeader("Content-Type", "application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setAuth(authScheme).build();
    }

    public RequestSpecification getRequestSpecificationsForGetRequest() throws IOException {
        authScheme.setUserName("user");
        authScheme.setPassword(pat);

        return new RequestSpecBuilder().setBaseUri(PropertyReader.getBaseUri())
                .addPathParam("organization", organization)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setAuth(authScheme).build();
    }
}

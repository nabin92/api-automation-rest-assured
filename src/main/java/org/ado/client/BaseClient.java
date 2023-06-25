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

    public RequestSpecification postRequestSpecification() throws IOException {
        authScheme.setUserName("user");
        authScheme.setPassword(PropertyReader.getPAT());

        return new RequestSpecBuilder().setBaseUri(PropertyReader.getBaseUri())
                .addQueryParam("api-version", 7.0)
                .addPathParam("organization", PropertyReader.getOrganization())
                .addHeader("Content-Type", "application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setAuth(authScheme).build();
    }

    public RequestSpecification getRequestSpecifications() throws IOException {
        authScheme.setUserName("user");
        authScheme.setPassword(PropertyReader.getPAT());

        return new RequestSpecBuilder().setBaseUri(PropertyReader.getBaseUri())
                .addPathParam("organization", PropertyReader.getOrganization())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setAuth(authScheme).build();
    }
}

package org.ado.client;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;
import util.PropertyReader;

public class BaseClient {

    protected String project = "TestTribeMeetUp";
    PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();

    public RequestSpecification postRequestSpecification() {
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

    public RequestSpecification getRequestSpecifications() {
        authScheme.setUserName("user");
        authScheme.setPassword(PropertyReader.getPAT());

        return new RequestSpecBuilder().setBaseUri(PropertyReader.getBaseUri())
                .addPathParam("organization", PropertyReader.getOrganization())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setAuth(authScheme).build();
    }
}

package org.ado.reponse;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

public class ResponseSpec {
    public ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_OK)
                .expectContentType("application/json")
                .expectCookie("VstsSession")
                .expectBody("count", notNullValue())
                .expectBody("$", hasKey("count"))
                .expectBody("value[0]", hasKey("id"))
                .build();
    }
}

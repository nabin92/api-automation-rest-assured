package org.ado.client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.ado.model.project.create.ProjectRequest;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RestClient extends BaseClient {

    public Response getProjects() throws IOException {
        RequestSpecification request = given().spec(getRequestSpecifications());
        return request.get("{organization}/_apis/projects/");
    }

    public Response getProcess() throws IOException {
        RequestSpecification request = given().spec(getRequestSpecifications());
        return request.get("{organization}/_apis/process/processes");
    }

    public Response createProject(ProjectRequest projectRequest) throws IOException {
        RequestSpecification request = given()
                .spec(postRequestSpecification())
                .body(projectRequest);
        return request.post("{organization}/_apis/projects");
    }

}

package org.ado.client;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.ado.model.project.create.ProjectRequest;

import java.io.FileNotFoundException;
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

    public Response deleteProject(String id) {
        RequestSpecification request = given()
                .queryParam("api-version", 7.0)
                .pathParam("organization", organization)
                .pathParam("id", id)
                .filter(new RequestLoggingFilter())
                .auth().preemptive()
                .basic("user", pat);
        return request.delete("{organization}/_apis/projects/{id}");

    }

//        public Response CreateProjectWithSpecBuilder(ProjectRequest projectRequest) {
//            RequestSpecification request = given().spec(getRequestSpecifications())
//                    .body(projectRequest);
//            return request.post("{organization}/_apis/projects");
//        }

//        public Response getWorkItemTypes() {
//            setBaseUrl();
//            RequestSpecification request = given()
//                    .queryParam("api-version", 7.0)
//                    .pathParam("organization", organization)
//                    .pathParam("project", project)
//                    .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
//                    .auth().preemptive()
//                    .basic("user", pat);
//            return request.get("{organization}/{project}/_apis/wit/workitemtypes");
//        }
}

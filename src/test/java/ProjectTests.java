import io.restassured.response.Response;
import org.ado.client.RestClient;
import org.ado.fixture.CreateProjectFixture;
import org.ado.reponse.ResponseSpec;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProjectTests {

    RestClient restClient = new RestClient();
    ResponseSpec responseSpec = new ResponseSpec();

    CreateProjectFixture fixture = new CreateProjectFixture();

    @Test
    public void shouldGetAllProjects() throws IOException {
        Response response = restClient.getProjects();
        response.then().spec(responseSpec.getResponseSpec());
    }

    @Test
    public void shouldGetTemplateIdAndCreateNewProject() throws IOException {
        Response res = restClient.getProcess();
        res.then().statusCode(200);
        String templateId = res.jsonPath().getString("value[0].id");
        fixture.createProjectRequest(templateId);
        Response response = restClient.createProject(fixture.createProjectRequest(templateId));
        response.then().statusCode(202);
    }
}

import io.restassured.response.Response;
import org.ado.client.RestClient;
import org.ado.fixture.CreateProjectFixture;
import org.ado.model.project.get.Project;
import org.ado.reponse.ResponseSpec;
import org.testng.annotations.Test;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class ProjectTests {

    RestClient restClient = new RestClient();
    ResponseSpec responseSpec = new ResponseSpec();

    CreateProjectFixture fixture = new CreateProjectFixture();

    @Test
    public void shouldGetAllProjects()  {
        Response response = restClient.getProjects();
        Project project = response
                .then()
                .spec(responseSpec.getResponseSpec())
                .extract()
                .as(Project.class);
        assertThat(project.getCount(), greaterThanOrEqualTo(1));
    }

    @Test
    public void shouldGetTemplateIdAndCreateNewProject() {
        Response res = restClient.getProcess();
        res.then().statusCode(SC_OK);
        String templateId = res.jsonPath().getString("value[0].id");
        fixture.createProjectRequest(templateId);
        Response response = restClient.createProject(fixture.createProjectRequest(templateId));
        response.then().statusCode(SC_ACCEPTED);
    }
}

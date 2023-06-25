import io.restassured.response.Response;
import org.ado.client.RestClient;
import org.ado.reponse.ResponseSpec;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ProjectTest {

    RestClient restClient=new RestClient();
    ResponseSpec responseSpec= new ResponseSpec();
    @Test
    public void shouldGetAllProjects() throws IOException {
        Response response = restClient.getProjects();
        response.then().spec(responseSpec.getResponseSpec());
    }
}

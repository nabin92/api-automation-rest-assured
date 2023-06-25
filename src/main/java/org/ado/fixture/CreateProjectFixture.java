package org.ado.fixture;
import com.github.javafaker.Faker;
import org.ado.model.project.create.Capabilities;
import org.ado.model.project.create.ProcessTemplate;
import org.ado.model.project.create.ProjectRequest;
import org.ado.model.project.create.VersionControl;

public class CreateProjectFixture {
    Faker faker = new Faker();

    public ProjectRequest createProjectRequest(String templateId) {
        return ProjectRequest.builder()
                .name(faker.name().firstName())
                .description(faker.name().firstName())
                .capabilities(Capabilities.builder()
                        .processTemplate(ProcessTemplate
                                .builder()
                                .templateTypeId(templateId)
                                .build())
                        .versioncontrol(VersionControl
                                .builder()
                                .sourceControlType("Git").
                                build())
                        .build())
                .build();
    }
}

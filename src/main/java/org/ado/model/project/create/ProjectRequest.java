package org.ado.model.project.create;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProjectRequest {
    private String name;
    private String description;
    private Capabilities capabilities;
}

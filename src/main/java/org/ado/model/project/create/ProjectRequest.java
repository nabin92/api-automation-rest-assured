package org.ado.model.project.create;

import lombok.Builder;

@Builder
public class ProjectRequest {
    private String name;
    private String description;
    private Capabilities capabilities;
}

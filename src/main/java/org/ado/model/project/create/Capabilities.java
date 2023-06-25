package org.ado.model.project.create;

import lombok.Builder;

@Builder
public class Capabilities {
    private VersionControl versioncontrol;
    private ProcessTemplate processTemplate;
}

package org.ado.model.project.create;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Capabilities {
    private VersionControl versioncontrol;
    private ProcessTemplate processTemplate;
}

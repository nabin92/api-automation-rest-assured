package org.ado.model.project.create;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VersionControl {
    private String sourceControlType;

}

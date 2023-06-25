package org.ado.model.project.get;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Value {
    private String id;
    private String name;
    private String url;
    private String state;
    private int revision;
    private String visibility;
    private String lastUpdateTime;

}

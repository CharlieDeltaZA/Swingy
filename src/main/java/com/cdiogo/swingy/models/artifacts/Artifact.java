package com.cdiogo.swingy.models.artifacts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Artifact {
    protected String artifactName;
    protected int artifactValue;
    protected String artifactTrait;

    @Override
    public String toString() {
        return(String.format("%s (+%d %s)", this.artifactName, this.artifactValue, this.artifactTrait));
    }
    
}
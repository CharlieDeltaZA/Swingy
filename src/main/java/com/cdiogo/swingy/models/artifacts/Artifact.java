package com.cdiogo.swingy.models.artifacts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Artifact {
    protected String artifactName;
    protected int artifactValue;
    // protected String artifactType;
    protected String artifactTrait;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return(String.format("%s (+%d %s)", this.artifactName, this.artifactValue, this.artifactTrait));
    }
    
}
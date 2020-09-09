package com.cdiogo.swingy.models.artifacts;

public class Helm extends Artifact {

    public Helm(String name) {
        int value = 0;
        this.setArtifactName(name);

        switch (name) {
            case "Balaclava":
                value = 8;
                break;
            case "Chainmail":
                value = 10;
                break;
            case "Quen":
                value = 5;
                break;
            case "None":
                break;
            default:
                System.out.println(String.format("Unrecognized Helm: '%s'", name));
                System.exit(0);
        }
        this.setArtifactValue(value);
        this.setArtifactTrait("HP");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
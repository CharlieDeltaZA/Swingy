package com.cdiogo.swingy.models.artifacts;

public class Armour extends Artifact {

    public Armour(String name) {
        int value = 0;
        this.setArtifactName(name);

        switch (name) {
            case "Leather Armour":
                value = 4;
                break;
            case "Chainmail":
                value = 7;
                break;
            case "Quen":
                value = 6;
                break;
            case "Knights Armour":
                value = 9;
                break;
            case "Shield":
                value = 2;
                break;
            default:
                System.out.println(String.format("Unrecognized Armour: '%s'", name));
                System.exit(0);
        }
        this.setArtifactValue(value);
        this.setArtifactTrait("Def");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
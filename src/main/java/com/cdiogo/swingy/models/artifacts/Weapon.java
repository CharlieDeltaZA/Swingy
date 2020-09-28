package com.cdiogo.swingy.models.artifacts;

public class Weapon extends Artifact {

    public Weapon(String name) {
        int value = 0;
        this.setArtifactName(name);

        switch (name) {
            case "Great Axe":
                value = 9;
                break;
            case "Short Bow":
                value = 6;
                break;
            case "Magic Missle":
                value = 10;
                break;
            case "Dagger":
                value = 4;
                break;
            case "Silver Sword":
                value = 8;
                break;
            case "None":
                value = 0;
                break;
            default:
                System.out.println(String.format("Unrecognized Weapon: '%s'", name));
                System.exit(0);
        }
        this.setArtifactValue(value);
        this.setArtifactTrait("Atk");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
package com.cdiogo.swingy.models.villains;

import lombok.Setter;
import lombok.Getter;

import java.util.Random;
import javax.validation.constraints.NotNull;

import com.cdiogo.swingy.models.artifacts.Artifact;

@Getter
@Setter
public class Villain {
    @NotNull
    protected String name;

    @NotNull
    protected int attack;

    @NotNull
    protected int defense;

    @NotNull
    protected int hp;

    @NotNull
    protected int xp;

    @NotNull
    protected int positionX;

    @NotNull
    protected int positionY;

    protected boolean defeated;

    protected Artifact artifact;

    // Villains : Wraith ; Bandit ; Leshen ; Vampire
    public Villain(String name, int level) {
        int atkMin = 0;
        int defMin = 0;
        this.name = name;
        this.defeated = false;

        Random random = new Random();

        // Might need to tweak these values later
        switch (name) {
            case "Wraith":
                atkMin = 9;
                defMin = 7;
                this.xp = (250 * level);
                this.hp = random.nextInt(45) + 25;
                break;
            case "Bandit":
                atkMin = 8;
                defMin = 6;
                this.xp = (150 * level);
                this.hp = random.nextInt(45) + 25;
                break;
            case "Leshen":
                atkMin = 12;
                defMin = 10;
                this.xp = (350 * level);
                this.hp = random.nextInt(50) + 40;
                break;
            case "Vampire":
                atkMin = 8;
                defMin = 9;
                this.xp = (200 * level);
                this.hp = random.nextInt(45) + 30;
                break;
            default:
                System.out.println(String.format("Unrecognized Villain type '%s'", name));
                System.exit(0);
        }

        this.attack = atkMin + random.nextInt((level + 5));
        this.defense = defMin + random.nextInt((level + 5));

        // System.out.println(String.format("atkMin: %d defMin: %d", atkMin, defMin));

    }

    @Override
    public String toString() {
        return (String.format("%s - HP: %d Atk: %d Def: %d", this.name, this.hp, this.attack, this.defense));
    }

    public String debugCoords() {
        return (String.format("X: %d Y: %d", this.positionX, this.positionY));
    }
}
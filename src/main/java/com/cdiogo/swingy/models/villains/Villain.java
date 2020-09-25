package com.cdiogo.swingy.models.villains;

import lombok.Setter;
import lombok.Getter;

import java.util.Random;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cdiogo.swingy.models.artifacts.Artifact;

@Getter
@Setter
public class Villain {
    @NotNull
    @NotBlank
    protected String name;

    @NotNull
    @Min(value=0, message="Attack cannot be lower than 0")
    protected int attack;

    @NotNull
    @Min(value=0, message="Defense cannot be lower than 0")
    protected int defense;

    @NotNull
    @Min(value=0, message="Health cannot be lower than 0")
    protected int hp;

    @NotNull
    @Min(value=0, message="Experience cannot be lower than 0")
    protected int xp;

    @NotNull
    protected int positionX;

    @NotNull
    protected int positionY;

    protected boolean defeated;

    @NotNull
    protected Artifact artifact;

    // Villains : Wraith ; Bandit ; Leshen ; Vampire
    public Villain(String name, int level) {
        int atkMin = 0;
        int defMin = 0;
        double multiplier = (1.0 + (((double)level / 10.0) - 0.1));
        this.name = name;
        this.defeated = false;

        Random random = new Random();

        // Might need to tweak these values later
        switch (name) {
            case "Wraith":
                atkMin = 9;
                defMin = 7;
                this.xp = (int)(250 * multiplier);
                this.hp = random.nextInt(45) + 25;
                break;
            case "Bandit":
                atkMin = 8;
                defMin = 6;
                this.xp = (int)(150 * multiplier);
                this.hp = random.nextInt(45) + 25;
                break;
            case "Leshen":
                atkMin = 12;
                defMin = 10;
                this.xp = (int)(350 * multiplier);
                this.hp = random.nextInt(50) + 40;
                break;
            case "Vampire":
                atkMin = 8;
                defMin = 9;
                this.xp = (int)(200 * multiplier);
                this.hp = random.nextInt(45) + 30;
                break;
            default:
                System.out.println(String.format("Unrecognized Villain type '%s'", name));
                System.exit(0);
        }

        this.attack = atkMin + random.nextInt((level + 5));
        this.defense = defMin + random.nextInt((level + 5));

        // System.out.println(String.format("Multiplier: %f", multiplier));

    }

    @Override
    public String toString() {
        return (String.format("%s - HP: %d Atk: %d Def: %d", this.name, this.hp, this.attack, this.defense));
    }

    public String debugCoords() {
        return (String.format("X: %d Y: %d", this.positionX, this.positionY));
    }
}
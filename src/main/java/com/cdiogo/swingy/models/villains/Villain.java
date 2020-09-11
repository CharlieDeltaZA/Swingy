package com.cdiogo.swingy.models.villains;

import lombok.Setter;
import lombok.Getter;

import java.util.Random;
import javax.validation.constraints.NotNull;

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
    protected int xp;

    @NotNull
    protected int positionX;

    @NotNull
    protected int positionY;

    // protected artifact

    // Villains : Wraith ; Bandit ; Leshen ; Vampire
    public Villain(String name, int level) {
        int atkMin = 0;
        int defMin = 0;
        this.name = name;

        Random random = new Random();

        // Might need to tweak these values later
        switch (name) {
            case "Wraith":
                atkMin = 6;
                defMin = 5;
                this.xp = 250;
                break;
            case "Bandit":
                atkMin = 4;
                defMin = 5;
                this.xp = 150;
                break;
            case "Leshen":
                atkMin = 8;
                defMin = 7;
                this.xp = 350;
                break;
            case "Vampire":
                atkMin = 5;
                defMin = 6;
                this.xp = 200;
                break;
            default:
                System.out.println(String.format("Unrecognized Villain type '%s'", name));
                System.exit(0);
        }

        this.attack = atkMin + random.nextInt(level);
        this.defense = defMin + random.nextInt(level);

        // System.out.println(String.format("atkMin: %d defMin: %d", atkMin, defMin));

    }

    @Override
    public String toString() {
        return (String.format("%s - Atk: %d Def: %d", this.name, this.attack, this.defense));
    }
}
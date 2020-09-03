package com.cdiogo.swingy.models.heros;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wizard extends Player {
    public Wizard(String heroName, String heroClass) {
        super(heroName, heroClass, 1, 1000, 50, 8, 5);
    }

    public Wizard(String heroName, String heroClass, int level, int xp, int health, int attack, int defense) {
        super(heroName, heroClass, level, xp, health, attack, defense);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
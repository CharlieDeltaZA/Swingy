package com.cdiogo.swingy.models.heroes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rogue extends Player {
    public Rogue(String heroName, String heroClass) {
        super(heroName, heroClass, 1, 1000, 40, 6, 6);
    }

    public Rogue(String heroName, String heroClass, int level, int xp, int health, int attack, int defense) {
        super(heroName, heroClass, level, xp, health, attack, defense);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
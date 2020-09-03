package com.cdiogo.swingy.models.heros;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fighter extends Player {
    public Fighter(String heroName, String heroClass) {
        super(heroName, heroClass, 1, 1000, 70, 10, 7);
    }

    public Fighter(String heroName, String heroClass, int level, int xp, int health, int attack, int defense) {
        super(heroName, heroClass, level, xp, health, attack, defense);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
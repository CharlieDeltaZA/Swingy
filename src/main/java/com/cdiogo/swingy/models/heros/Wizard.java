package com.cdiogo.swingy.models.heros;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wizard extends Player {
    public Wizard(String heroName, String heroClass) {
        super(heroName, heroClass, -69, 15, 20, 100, 3);
        // xp = -5;
        // hp = 100;
        // attack = 20;
        // defense = 15;
        // level = 3;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
package com.cdiogo.swingy.models.heroes;

import com.cdiogo.swingy.models.artifacts.Armour;
import com.cdiogo.swingy.models.artifacts.Helm;
import com.cdiogo.swingy.models.artifacts.Weapon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ranger extends Player {
    // New Character
    public Ranger(String heroName, String heroClass) {
        super(heroName, heroClass, 0, 0, 60, 7, 4);
        this.weapon = new Weapon("Short Bow");
        this.armour = new Armour("Leather Armour");
        this.helm = new Helm("None");
    }

    // Saved Character
    public Ranger(String heroName, String heroClass, int level, int xp, int health, int attack, int defense, String weapon, String armour, String helm) {
        super(heroName, heroClass, level, xp, health, attack, defense);
        this.weapon = new Weapon(weapon);
        this.armour = new Armour(armour);
        this.helm = new Helm(helm);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
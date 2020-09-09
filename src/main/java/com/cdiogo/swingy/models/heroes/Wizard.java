package com.cdiogo.swingy.models.heroes;

import com.cdiogo.swingy.models.artifacts.Armour;
import com.cdiogo.swingy.models.artifacts.Helm;
import com.cdiogo.swingy.models.artifacts.Weapon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wizard extends Player {

    // New Character
    public Wizard(String heroName, String heroClass) {
        super(heroName, heroClass, 1, 1000, 50, 8, 5);
        this.weapon = new Weapon("Magic Missle");
        this.armour = new Armour("Quen");
        this.helm = new Helm("None");
    }

    // Saved Character
    public Wizard(String heroName, String heroClass, int level, int xp, int health, int attack, int defense, String weapon, String armour, String helm) {
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
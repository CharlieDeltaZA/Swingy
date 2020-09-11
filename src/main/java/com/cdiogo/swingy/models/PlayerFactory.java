package com.cdiogo.swingy.models;

import com.cdiogo.swingy.models.heroes.Fighter;
import com.cdiogo.swingy.models.heroes.Player;
import com.cdiogo.swingy.models.heroes.Ranger;
import com.cdiogo.swingy.models.heroes.Rogue;
import com.cdiogo.swingy.models.heroes.Wizard;

public abstract class PlayerFactory {

    public static Player newPlayer(String heroName, String heroClass) {
        switch (heroClass) {
            case "Ranger":
                return (new Ranger(heroName, heroClass));
            case "Wizard":
                return (new Wizard(heroName, heroClass));
            case "Fighter":
                return (new Fighter(heroName, heroClass));
            case "Rogue":
                return (new Rogue(heroName, heroClass));
            default:
                System.out.println(String.format("Hero Class '%s' not recognized", heroClass));
                System.exit(0);
                // break;
        }
        return (null);
    }

    public static Player existingPlayer(String heroName, String heroClass, int level, int xp, int health, int attack, int defense, String weapon, String armour, String helm) {
        switch (heroClass) {
            case "Ranger":
                return (new Ranger(heroName, heroClass, level, xp, health, attack, defense, weapon, armour, helm));
            case "Wizard":
                return (new Wizard(heroName, heroClass, level, xp, health, attack, defense, weapon, armour, helm));
            case "Fighter":
                return (new Fighter(heroName, heroClass, level, xp, health, attack, defense, weapon, armour, helm));
            case "Rogue":
                return (new Rogue(heroName, heroClass, level, xp, health, attack, defense, weapon, armour, helm));
            default:
                System.out.println(String.format("Hero Class '%s' not recognized", heroClass));
                System.exit(0);
                // break;
        }
        return (null);
    }
}

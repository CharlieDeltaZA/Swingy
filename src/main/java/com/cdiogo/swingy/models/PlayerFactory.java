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
                // break;
        
            case "Wizard":
                return (new Wizard(heroName, heroClass));
                // break;

            case "Fighter":
                return (new Fighter(heroName, heroClass));
                // break;

            case "Rogue":
                return (new Rogue(heroName, heroClass));
                // break;

            default:
                System.out.println(String.format("Hero Class '%s' not recognized", heroClass));
                break;
        }
        return (null);
    }

    public static Player existingPlayer(String heroName, String heroClass, int level, int xp, int health, int attack, int defense) {
        switch (heroClass) {
            case "Ranger":
                return (new Ranger(heroName, heroClass, level, xp, health, attack, defense));
                // break;
        
            case "Wizard":
                return (new Wizard(heroName, heroClass, level, xp, health, attack, defense));
                // break;

            case "Fighter":
                return (new Fighter(heroName, heroClass, level, xp, health, attack, defense));
                // break;

            case "Rogue":
                return (new Rogue(heroName, heroClass, level, xp, health, attack, defense));
                // break;

            default:
                System.out.println(String.format("Hero Class '%s' not recognized", heroClass));
                break;
        }
        return (null);
    }
}

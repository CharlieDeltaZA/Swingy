package com.cdiogo.swingy.models.heros;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
    @NotNull
    private String heroName;

    @NotNull
    private String heroClass;

    @NotNull
    @Min(value=1, message="Level cannot be lower than 1")
    @Max(value=10, message="Level cannot be higher than 10")
    private int level;

    @NotNull
    @Min(value=0, message="Experience cannot be lower than 0")
    private int xp;

    @NotNull
    @Min(value=0, message="Attack cannot be lower than 0")
    private int attack;

    @NotNull
    @Min(value=0, message="Defense cannot be lower than 0")
    private int defense;

    @NotNull
    @Min(value=0, message="Health cannot be lower than 0")
    private int hp;

    public Player(String heroName, String heroClass, @Min(0) int xp, int def, int atk, int hp, int lvl) {
        this.setHeroName(heroName);
        this.setHeroClass(heroClass);
        this.setXp(xp);
        this.setHp(hp);
        this.setDefense(def);
        this.setAttack(atk);
        this.setLevel(lvl);
    }

    @Override
    public String toString() {
        return (String.format("%s the %s, Atk: %d Def: %d XP: %d Lvl: %d HP: %d", this.heroName, this.heroClass, this.attack, this.defense, this.xp, this.level, this.hp));
    }
    
}
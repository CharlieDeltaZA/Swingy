package com.cdiogo.swingy.models.heros;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Player {
    @NotNull
    protected String heroName;

    @NotNull
    protected String heroClass;

    @NotNull
    @Min(value=1, message="Level cannot be lower than 1")
    @Max(value=10, message="Level cannot be higher than 10")
    protected int level;

    @NotNull
    @Min(value=0, message="Experience cannot be lower than 0")
    protected int xp;

    @NotNull
    @Min(value=0, message="Attack cannot be lower than 0")
    protected int attack;

    @NotNull
    @Min(value=0, message="Defense cannot be lower than 0")
    protected int defense;

    @NotNull
    @Min(value=0, message="Health cannot be lower than 0")
    protected int hp;

    public Player(String heroName, String heroClass, int lvl, int xp, int hp, int atk, int def) {
        this.setHeroName(heroName);
        this.setHeroClass(heroClass);
        this.setLevel(lvl);
        this.setXp(xp);
        this.setHp(hp);
        this.setAttack(atk);
        this.setDefense(def);
    }

    @Override
    public String toString() {
        return (String.format("%s (%s), Atk: %d Def: %d XP: %d Lvl: %d HP: %d", this.heroName, this.heroClass, this.attack, this.defense, this.xp, this.level, this.hp));
    }
    
}
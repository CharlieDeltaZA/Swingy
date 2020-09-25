package com.cdiogo.swingy.models.heroes;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cdiogo.swingy.models.artifacts.Armour;
import com.cdiogo.swingy.models.artifacts.Helm;
import com.cdiogo.swingy.models.artifacts.Weapon;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Player {
    @NotNull
    @NotBlank(message = "Hero name must not be blank")
    protected String heroName;

    @NotNull
    @NotBlank(message = "Hero class must not be blank")
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

    @NotNull
    protected Armour armour;
    
    @NotNull
    protected Weapon weapon;

    @NotNull
    protected Helm helm;

    @NotNull
    @Min(value = 0, message = "Edge of map exceeded")
    protected int positionX;

    @NotNull
    @Min(value = 0, message = "Edge of map exceeded")
    protected int positionY;

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
        return (String.format("%s (%s)\nLvl: %d XP: %d HP: %d\nAtk: %d Def: %d\nWeapon: %s\nArmour: %s\nHelm: %s", 
            this.heroName, this.heroClass, this.level, this.xp, this.hp, this.attack, this.defense, this.weapon.toString(), this.armour.toString(), this.helm.toString()));
    }
    
}
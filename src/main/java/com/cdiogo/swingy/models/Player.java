package com.cdiogo.swingy.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
    String heroName;
    String heroClass;
    int level;
    int xp;
    int attack;
    int defense;
    int hp;
    
}
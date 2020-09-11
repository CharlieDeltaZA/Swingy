package com.cdiogo.swingy.models;

import java.util.List;

import com.cdiogo.swingy.controllers.GameController;
import com.cdiogo.swingy.models.villains.Villain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Map {
    private GameController controller;
    private char[][] map;
    private int mapSize;

    public Map(GameController controller, List<Villain> villains) {
        this.controller = controller;

        int level = controller.getHero().getLevel();
        mapSize = (level - 1) * 5 + 10 - (level % 2);
        // System.out.println(String.format("Level: %d ; mapSize: %d", level, mapSize));
        map = new char[mapSize][mapSize];
        int heroPos = (mapSize - 1) / 2;

        for (int i = 0; i < mapSize; i++) {
            for (int k = 0; k < mapSize; k++) {
                map[i][k] = '.';
            }
        }

        map[heroPos][heroPos] = 'H';
        controller.getHero().setPositionX(heroPos);
        controller.getHero().setPositionY(heroPos);
    }
}

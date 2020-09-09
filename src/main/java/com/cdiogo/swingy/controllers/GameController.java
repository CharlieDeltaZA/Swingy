package com.cdiogo.swingy.controllers;

import lombok.Setter;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cdiogo.swingy.models.PlayerFactory;
import com.cdiogo.swingy.models.heroes.Player;
import com.cdiogo.swingy.views.ConsoleDisplay;

@Getter
@Setter
public class GameController {
    ConsoleDisplay console = new ConsoleDisplay(this);
    Player hero;
    List<Player> heroes;

    public GameController(String display) {
        switch (display) {
            case "console":
                System.out.println("Cool, lets console");
                console.startScreen();
                break;
            case "gui":
                System.out.println("Not yet mate");
                break;
            default:
                System.out.println(String.format("Display type '%s' not supported, exiting...", display));
                System.exit(0);
        }
    }

    public void handleInput(String input) {
        switch (input) {
            case "c":
                String heroName = console.createCharName();
                String heroClass = console.createCharClass();
                hero = PlayerFactory.newPlayer(heroName, heroClass);
                System.out.println(hero.toString());
                break;

            case "l":
                heroes = loadFromFile();
                System.out.println("List of heroes");
                for (Player hero : heroes) {
                    System.out.println(hero.toString());
                }
                String choice = console.loadChar(heroes);
                Integer index = Integer.parseInt(choice);
                hero = heroes.get(index-1);
                System.out.println(hero.toString());
                break;

            default:
                break;
        }
    }

    private List<Player> loadFromFile() {
        String filename = System.getProperty("user.dir") + "/saves.txt";
        List<Player> heroes = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            // String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(",");
                try {
                    Player hero = PlayerFactory.existingPlayer(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]),
                        Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]), Integer.parseInt(splitLine[6]));
                    if (hero != null) {
                        heroes.add(hero);
                    }
                    
                } catch (NumberFormatException e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
            }
            reader.close();
            System.out.println(heroes);
            return heroes;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

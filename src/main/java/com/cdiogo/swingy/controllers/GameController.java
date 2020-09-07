package com.cdiogo.swingy.controllers;

import lombok.Setter;

import com.cdiogo.swingy.views.ConsoleDisplay;

import lombok.Getter;

@Getter
@Setter
public class GameController {
    ConsoleDisplay console = new ConsoleDisplay(this);

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
                break;

            case "l":
                console.loadChar();
                break;
        
            default:
                break;
        }
    }
}

package com.cdiogo.swingy.controllers;

import lombok.Setter;

import com.cdiogo.swingy.views.ConsoleDisplay;

import lombok.Getter;

@Getter
@Setter
public class GameController {

    public GameController(String display) {
        switch (display) {
            case "console":
                System.out.println("Cool, lets console");
                ConsoleDisplay console = new ConsoleDisplay(this);
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
}

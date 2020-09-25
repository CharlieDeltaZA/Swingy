package com.cdiogo.swingy;

import com.cdiogo.swingy.controllers.GameController;

public class Main {
    public static void main(String[] args) {
        try {
            GameController controller = new GameController(args[0].toLowerCase());
            controller.playGame();
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please specificy a display to use: 'console' or 'gui'");
        }


    }
}
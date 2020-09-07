package com.cdiogo.swingy;

import com.cdiogo.swingy.controllers.GameController;
import com.cdiogo.swingy.models.heros.Ranger;
import com.cdiogo.swingy.models.heros.Player;

public class Main {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        Player ranger = new Ranger("Charlie", "Ranger");
        System.out.println(ranger.toString());
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        try {
            GameController controller = new GameController(args[0].toLowerCase());
            // controller.playGame();
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please specificy a display to use: 'console' or 'gui'");
        }


    }
}
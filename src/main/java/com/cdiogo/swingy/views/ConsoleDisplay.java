package com.cdiogo.swingy.views;

import java.util.List;
import java.util.Scanner;

import com.cdiogo.swingy.controllers.GameController;
import com.cdiogo.swingy.models.heroes.Player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsoleDisplay {
    private Scanner sysin;
    private GameController controller;

    public ConsoleDisplay(GameController controller) {
        sysin = new Scanner(System.in);
        this.controller = controller;
    }

    public void startScreen() {
        System.out.print("\033[H\033[2J");
        System.out.println("************************************************");
        System.out.println("*  WELCOME TO                                  *");
        System.out.println("*      _____          _                        *");
        System.out.println("*     /  ___|        (_)                       *");
        System.out.println("*     \\ `--.__      ___ _ __   __ _ _   _      *");
        System.out.println("*      `--. \\ \\ /\\ / / | '_ \\ / _` | | | |     *");
        System.out.println("*     /\\__/ /\\ V  V /| | | | | (_| | |_| |     *");
        System.out.println("*     \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |     *");
        System.out.println("*                              __/ | __/ |     *");
        System.out.println("*                             |___/ |___/      *");
        System.out.println("*                                              *");
        System.out.println("*     c - Create a Character                   *");
        System.out.println("*     l - Load an existing Character           *");
        System.out.println("*                                              *");
        System.out.println("************************************************");
        System.out.print("Your choice: ");
        String choice = sysin.next();
        System.out.println("You chose... something! " + choice);
        controller.handleInput(choice);
    }

	public String createCharName() {
        System.out.print("\033[H\033[2J");
        System.out.println("***************************");
        System.out.println("*                         *");
        System.out.println("*     Enter Hero Name     *");
        System.out.println("*                         *");
        System.out.println("***************************");
        System.out.print("Hero Name: ");
        String choice = sysin.next();
        // controller.handleInput(choice);
        return (choice);
    }
    
    public String createCharClass() {
        String heroClass = "";

        System.out.print("\033[H\033[2J");
        System.out.println("****************************");
        System.out.println("*                          *");
        System.out.println("*     Enter Hero Class     *");
        System.out.println("*                          *");
        System.out.println("*     1 - Ranger           *");
        System.out.println("*     2 - Wizard           *");
        System.out.println("*     3 - Fighter          *");
        System.out.println("*     4 - Rogue            *");
        System.out.println("*                          *");
        System.out.println("****************************");
        System.out.print("Hero Class: ");
        String choice = sysin.next();
        // controller.handleInput(choice);
        switch (choice) {
            case "1":
                heroClass = "Ranger";
                break;
            case "2":
                heroClass = "Wizard";
                break;
            case "3":
                heroClass = "Fighter";
                break;
            case "4":
                heroClass = "Rogue";
                break;
            default:
                System.out.println("Unrecognized class, try again");
                break;
        }
        return (heroClass);
    }

	public String loadChar(List<Player> heroes) {
        Integer i = 1;
        System.out.print("\033[H\033[2J");
        System.out.println("*****************************");
        System.out.println("                             ");
        System.out.println("        Choose a Hero        ");
        System.out.println("                             ");
        try {
            for (Player hero : heroes) {
                System.out.println(String.format("   %d - %s : %s ", i, hero.getHeroName(), hero.getHeroClass()));
                i++;
            }
            
        } catch (NullPointerException e) {
            //TODO: handle exception
            e.printStackTrace();
        }


        System.out.println("                             ");
        System.out.println("*****************************");
        String choice = sysin.next();
        return (choice);
	}
}

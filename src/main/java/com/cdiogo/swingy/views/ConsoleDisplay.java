package com.cdiogo.swingy.views;

import java.util.List;
import java.util.Scanner;

import com.cdiogo.swingy.controllers.GameController;
import com.cdiogo.swingy.models.heroes.Player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsoleDisplay implements Display {
    private Scanner sysin;
    private GameController controller;

    public ConsoleDisplay(GameController controller) {
        sysin = new Scanner(System.in);
        this.controller = controller;
    }

    @Override
    public void startScreen() {
        String choice = "";

        while (!(choice.equals("c") || choice.equals("l"))) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
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
            choice = sysin.next();
        }

        // System.out.println("You chose... something! " + choice);
        controller.handleInput(choice);
    }

    @Override
	public String createCharName() {
        String choice = "";

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("***************************");
        System.out.println("*                         *");
        System.out.println("*     Enter Hero Name     *");
        System.out.println("*                         *");
        System.out.println("***************************");
        System.out.print("Hero Name: ");
        choice = sysin.next();
        // controller.handleInput(choice);
        return (choice);
    }
    
    @Override
    public void createCharClass() {
        String choice = "";

        while (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4"))) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
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
            choice = sysin.next();
        }
        controller.handleInput(choice);
    }

    @Override
	public void loadChar(List<Player> heroes) {
        int i = 1;
        String choice;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*****************************************");
        System.out.println("                                         ");
        System.out.println("              Choose a Hero              ");
        System.out.println("                                         ");
        try {
            for (Player hero : heroes) {
                System.out.println(String.format("   %d - %s : %s ", i, hero.getHeroName(), hero.getHeroClass()));
                i++;
            }
            
        } catch (NullPointerException e) {
            //TODO: handle exception
            e.printStackTrace();
        }


        System.out.println("                                         ");
        System.out.println("*****************************************");
        System.out.print("Your choice: ");
        choice = sysin.next();
        controller.handleInput(choice);
        // return (choice);
	}

    @Override
    public void renderGame() {
        // TODO Auto-generated method stub
        while (!controller.isGameOver()) {
            controller.displayState();
        }
    }

    @Override
    public void playGame() {
        String choice = "";
        char[][] map;

        while (!(choice.equals("w") || choice.equals("a") || choice.equals("s") || choice.equals("d")
                                    || choice.equals("q") || choice.equals("c"))) {

            System.out.println("*****************************************");
            System.out.println("*                                       *");
            System.out.println("*     w/a/s/d - Move                    *");
            System.out.println("*     q       - Quit                    *");
            System.out.println("*     c       - Save                    *");
            System.out.println("*                                       *");
            System.out.println("*****************************************");

            controller.getHero().toString();
            map = controller.getMap();

            for (int i = 0; i < map[0].length; i++) {
                for (int k = 0; k < map[0].length; k++) {
                    System.out.print(map[i][k]);
                }
                System.out.print("\n");
            }

            System.out.print("Your choice: ");
            choice = sysin.next();
        }

        controller.handleInput(choice);
    }

    @Override
    public void fightOrFlight() {
        System.out.println("Infi loop!");
    }
}

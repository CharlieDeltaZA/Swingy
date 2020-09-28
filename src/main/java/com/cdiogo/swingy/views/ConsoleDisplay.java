package com.cdiogo.swingy.views;

import java.util.List;
import java.util.Scanner;

import com.cdiogo.swingy.controllers.GameController;
import com.cdiogo.swingy.models.heroes.Player;
import com.cdiogo.swingy.models.villains.Villain;

public class ConsoleDisplay implements Display {
    private Scanner sysin;
    private GameController controller;
    private final String COL_GREEN = "\u001b[32m";
    private final String COL_CYAN = "\u001b[36m";
    private final String COL_RED = "\u001b[31m";
    private final String COL_RESET = "\u001b[0m";
    private boolean gui = false;
    
    public ConsoleDisplay(GameController controller) {
        sysin = new Scanner(System.in);
        this.controller = controller;
    }

    @Override
    public void startScreen() {
        String choice = "";

        while (!(choice.equals("c") || choice.equals("l") || choice.equals("x") || choice.equals("q"))) {
            System.out.print("\033[H\033[2J");
            System.out.println("+----------------------------------------------+");
            System.out.println("|  WELCOME TO                                  |");
            System.out.println("|      _____          _                        |");
            System.out.println("|     /  ___|        (_)                       |");
            System.out.println("|     \\ `--.__      ___ _ __   __ _ _   _      |");
            System.out.println("|      `--. \\ \\ /\\ / / | '_ \\ / _` | | | |     |");
            System.out.println("|     /\\__/ /\\ V  V /| | | | | (_| | |_| |     |");
            System.out.println("|     \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |     |");
            System.out.println("|                              __/ | __/ |     |");
            System.out.println("|                             |___/ |___/      |");
            System.out.println("|                                              |");
            System.out.println("|     c - Create a Character                   |");
            System.out.println("|     l - Load an existing Character           |");
            System.out.println("|     x - Switch to GUI                        |");
            System.out.println("|     q - Quit Game                            |");
            System.out.println("|                                              |");
            System.out.println("+----------------------------------------------+");
            System.out.print("Your choice: ");
            if (sysin.hasNext()) {
                choice = sysin.next();
            }
        }
        controller.handleInput(choice);
    }

    @Override
	public void createCharName() {
        String choice = "";

        while (choice.equals("")) {
            System.out.print("\033[H\033[2J");
            System.out.println("+-------------------------+");
            System.out.println("|                         |");
            System.out.println("|     Enter Hero Name     |");
            System.out.println("|                         |");
            System.out.println("+-------------------------+");
            System.out.print("Hero Name: ");
            if (sysin.hasNext()) {
                choice = sysin.nextLine();
            }
        }
        controller.handleInput(choice);
    }
    
    @Override
    public void createCharClass() {
        String choice = "";

        while (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("b"))) {
            System.out.print("\033[H\033[2J");
            System.out.println("+--------------------------+");
            System.out.println("|                          |");
            System.out.println("|     Enter Hero Class     |");
            System.out.println("|                          |");
            System.out.println("|     1 - Ranger           |");
            System.out.println("|     2 - Wizard           |");
            System.out.println("|     3 - Fighter          |");
            System.out.println("|     4 - Rogue            |");
            System.out.println("|                          |");
            System.out.println("|     b - Back to Menu     |");
            System.out.println("|                          |");
            System.out.println("+--------------------------+");
            System.out.print("Hero Class: ");
            if (sysin.hasNext()) {
                choice = sysin.next();
            }
        }
        controller.handleInput(choice);
    }

    @Override
	public void loadChar(List<Player> heroes) {
        int i = 1;
        String choice = "";

        while (!(choice.equals("b") || choice.matches("\\d+"))) {
            System.out.print("\033[H\033[2J");
            System.out.println("+---------------------------------------+");
            System.out.println("                                         ");
            System.out.println("              Choose a Hero              ");
            System.out.println("                                         ");
            try {
                if (heroes.size() != 0) {
                    for (Player hero : heroes) {
                        System.out.println(String.format("   %d - %s : %s ", i, hero.getHeroName(), hero.getHeroClass()));
                        i++;
                    }
                    i = 1;
                } else {
                    System.out.println("   No Saved Heroes found!                ");
                    System.out.println("   Try creating one instead              ");
                }
    
            } catch (NullPointerException e) {
                //TODO: handle exception
                System.out.println("Caught NullPtrExc");
                e.printStackTrace();
            }
    
            System.out.println("                                         ");
            System.out.println("   b - Back to Menu                      ");
            System.out.println("                                         ");
            System.out.println("+---------------------------------------+");
            System.out.print("Your choice: ");
            if (sysin.hasNext()) {
                choice = sysin.next();
            }
        }
        controller.handleInput(choice);
    }
    
    public void changeDisplay(boolean bool) {
        System.out.print("\033[H\033[2J");
        gui = bool;
    }

    @Override
    public void renderGame() {
        while (!controller.isGameOver() && !gui) {
            controller.displayState();
        }
    }

    @Override
    public void playGame() {
        String choice = "";
        char[][] map;

        while (!(choice.equals("w") || choice.equals("a") || choice.equals("s") || choice.equals("d")
                                    || choice.equals("q") || choice.equals("c") || choice.equals("x"))) {

            System.out.print("\033[H\033[2J");
            System.out.println("+---------------------------------------+");
            System.out.println("|                                       |");

            if (controller.isHeroEscaped()) {
                controller.setHeroEscaped(false);
                System.out.println("|     You have successfully escaped     |");
                System.out.println("|                                       |");
            }

            if (controller.isLevelUp()) {
                controller.setLevelUp(false);
                System.out.println("|         You have levelled up!         |");
                System.out.println("|                                       |");
            }

            if (controller.isSaved()) {
                controller.setSaved(false);
                System.out.println("|             Player Saved!             |");
                System.out.println("|                                       |");

            }

            System.out.println("|     w/a/s/d - Move Hero               |");
            System.out.println("|     c       - Save Hero               |");
            System.out.println("|     x       - Switch to GUI           |");
            System.out.println("|     q       - Quit Game               |");
            System.out.println("|                                       |");
            System.out.println("+---------------------------------------+");

            System.out.println(controller.getHero().toString());
            System.out.println("");
            map = controller.getMap();

            for (int i = 0; i < map[0].length; i++) {
                for (int k = 0; k < map[0].length; k++) {
                    if (map[i][k] == 'H') {
                        System.out.print(COL_GREEN + map[i][k] + COL_RESET);
                    } else if (map[i][k] == '.') {
                        System.out.print(COL_CYAN + map[i][k] + COL_RESET);
                    } else if (map[i][k] == 'V') {
                        System.out.print(COL_RED + map[i][k] + COL_RESET);
                    } else {
                        System.out.print(map[i][k]);
                    }
                    if (map[0].length < 35) {
                        System.out.print(" ");
                    }
                }
                System.out.print("\n");
            }

            System.out.print("Your choice: ");
            if (sysin.hasNext()) {
                choice = sysin.next();
            }
        }
        controller.handleInput(choice);
    }

    @Override
    public void fightOrFlight() {
        String choice = "";

        while (!(choice.equals("f") || choice.equals("r") || choice.equals("y") || choice.equals("n"))) {
            System.out.print("\033[H\033[2J");
            System.out.println("+--------------------------------------+");
            System.out.println("                                        ");
            System.out.println("    You have encountered a villain!     ");
            System.out.println("                                        ");
            System.out.println(String.format("    %s    ", controller.getCurrentEnemy().toString()));
            System.out.println("                                        ");
            System.out.println("    f - Fight the enemy                 ");
            System.out.println("    r - Attempt to flee                 ");
            System.out.println("                                        ");
            System.out.println("+--------------------------------------+");
            System.out.print("Your choice: ");
            if (sysin.hasNext()) {
                choice = sysin.next();
            }

        }
        controller.handleInput(choice);
    }

    @Override
    public void roundWon() {
        String choice = "";

        while (!(choice.equals("r") || choice.equals("q"))) {
            System.out.print("\033[H\033[2J");
            System.out.println("+-----------------------------------+");
            System.out.println("|                                   |");
            System.out.println("|      You have Successfully        |");
            System.out.println("|      completed this level!        |");
            System.out.println("|                                   |");
            System.out.println("|      Continue your adventure      |");
            System.out.println("|      from the main menu, or       |");
            System.out.println("|      try a new character, by      |");
            System.out.println("|      pressing 'l' to choose.      |");
            System.out.println("|                                   |");
            System.out.println("|      r - Return to Main Menu      |");
            System.out.println("|      q - Quit Game                |");
            System.out.println("|                                   |");
            System.out.println("+-----------------------------------+");
            System.out.print("Your choice: ");
            if (sysin.hasNext()) {
                choice = sysin.next();
            }
        }
        controller.handleInput(choice);
    }

    @Override
    public void quitGame() {
        String choice = "";

        while (!(choice.equals("y") || choice.equals("n"))) {
            System.out.print("\033[H\033[2J");
            System.out.println("+----------------------------------+");
            System.out.println("|                                  |");
            System.out.println("|      Are you sure you would      |");
            System.out.println("|      like to quit the game?      |");
            System.out.println("|                                  |");
            System.out.println("|      y - Save and Quit           |");
            System.out.println("|      n - Return to previous      |");
            System.out.println("|          screen                  |");
            System.out.println("|                                  |");
            System.out.println("+----------------------------------+");
            System.out.print("Your choice: ");
            if (sysin.hasNext()) {
                choice = sysin.next();
            }
        }
        controller.handleInput(choice);
    }

    @Override
    public void noEscape() {
        String choice = "";

        while (!(choice.equals("c"))) {
            System.out.print("\033[H\033[2J");
            System.out.println("+----------------------------------+");
            System.out.println("|                                  |");
            System.out.println("|     Your attempt to flee has     |");
            System.out.println("|        failed! Prepare for       |");
            System.out.println("|             BATTLE!              |");
            System.out.println("|                                  |");
            System.out.println("|           c - Continue           |");
            System.out.println("|                                  |");
            System.out.println("+----------------------------------+");
            System.out.print("Your choice: ");
            if (sysin.hasNext()) {
                choice = sysin.next();
            }
        }
        controller.handleInput(choice);

    }

    @Override
    public void afterAction() {
        String choice = "";
        Villain enemy = controller.getCurrentEnemy();

        if (enemy.getArtifact() != null) {
            while (!(choice.equals("y") || choice.equals("n"))) {
                System.out.print("\033[H\033[2J");
                System.out.println("+----------------------------------+");
                System.out.println("                                    ");
                System.out.println(String.format("    You have defeated the %s        ", enemy.getName()));
                System.out.println(String.format("           You gain %d XP       ", enemy.getXp()));
                System.out.println("                                    ");
                System.out.println("  This villain dropped an artifact! ");
                System.out.println(String.format("       %s", enemy.getArtifact().toString()));
                System.out.println("                                    ");
                System.out.println("     Would you like to equip it?    ");
                System.out.println("     y - Equip   //   n - Ignore    ");
                System.out.println("                                    ");
                System.out.println("+----------------------------------+");
                System.out.print("Your choice: ");
                if (sysin.hasNext()) {
                    choice = sysin.next();
                }
            }
        } else {
            while (!(choice.equals("c"))) {
                System.out.print("\033[H\033[2J");
                System.out.println("+----------------------------------+");
                System.out.println("                                    ");
                System.out.println(String.format("    You have defeated the %s        ", enemy.getName()));
                System.out.println(String.format("           You gain %d XP       ", enemy.getXp()));
                System.out.println("            c - Continue            ");
                System.out.println("                                    ");
                System.out.println("+----------------------------------+");
                System.out.print("Your choice: ");
                if (sysin.hasNext()) {
                    choice = sysin.next();
                }
            }
        }
        controller.handleInput(choice);
    }

    @Override
    public void gameOver() {
        String choice = "";

        while (!(choice.equals("r") || choice.equals("q"))) {
            System.out.print("\033[H\033[2J");
            System.out.println("+----------------------------------+");
            System.out.println("|                                  |");
            System.out.println("|            GAME  OVER            |");
            System.out.println("|                                  |");
            System.out.println("|      Your hero has died :(       |");
            System.out.println("|                                  |");
            System.out.println("|      You may return to the       |");
            System.out.println("|      menu and play again, or     |");
            System.out.println("|      you may quit.               |");
            System.out.println("|                                  |");
            System.out.println("|      r - Return to menu          |");
            System.out.println("|      q - Save and Quit           |");
            System.out.println("|                                  |");
            System.out.println("+----------------------------------+");
            System.out.print("Your choice: ");
            if (sysin.hasNext()) {
                choice = sysin.next();
            }
        }
        controller.handleInput(choice);
    }
}

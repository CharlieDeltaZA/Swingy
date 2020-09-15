package com.cdiogo.swingy.controllers;

import lombok.Setter;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cdiogo.swingy.models.Map;
import com.cdiogo.swingy.models.PlayerFactory;
import com.cdiogo.swingy.models.heroes.Player;
import com.cdiogo.swingy.models.villains.Villain;
import com.cdiogo.swingy.views.ConsoleDisplay;
import com.cdiogo.swingy.views.Display;

@Getter
@Setter
public class GameController {
    private ConsoleDisplay console = new ConsoleDisplay(this);
    // private GuiDisplay gui = new GuiDisplay(this);
    private Display display;
    private Player hero;
    private Villain currentEnemy;
    private List<Player> heroes;
    private List<Villain> villains;

    public enum gameState {
        START, SELECT, CREATE, PLAY, FIGHT_FLIGHT, NO_ESCAPE, GAME_OVER, WIN, QUIT
    }

    private gameState currentGameState;
    private boolean gameOver;
    private Map mapper;
    private char[][] map;
    private int xBeforeMove;
    private int yBeforeMove;

    public GameController(String displayType) {
        currentGameState = gameState.START;
        gameOver = false;
        mapper = new Map(this);
        heroes = loadFromFile();

        switch (displayType) {
            case "console":
                System.out.println("Cool, lets console");
                display = console;
                break;
            case "gui":
                System.out.println("Not yet mate");
                // display = gui;
                break;
            default:
                System.out.println(String.format("Display type '%s' not supported, exiting...", displayType));
                System.exit(0);
        }
    }

    public void handleInput(String input) {
        switch (currentGameState) {
            case START:
                switch (input) {
                    case "c":
                        currentGameState = gameState.CREATE;
                        break;

                    case "l":
                        currentGameState = gameState.SELECT;
                        break;

                    case "q":
                        currentGameState = gameState.QUIT;
                        break;

                    default:
                        System.out.println("Bad Choice - START");
                        System.exit(0);
                        // break;
                }
                break; // case START

            case CREATE:
                if (input.equals("b")) {
                    currentGameState = gameState.START;
                    break;
                }
                createHero(input);
                currentGameState = gameState.PLAY;
                break;

            case SELECT:
                if (input.equals("b")) {
                    currentGameState = gameState.START;
                    break;
                } else {
                    int index = Integer.parseInt(input);
                    hero = heroes.get(index - 1);
                    System.out.println(hero.toString());
                    initMap();
                    currentGameState = gameState.PLAY;
                }
                break;

            case PLAY:
                // Moves
                if (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")) {
                    movePlayer(input);
                    if (checkConflict()) {
                        currentGameState = gameState.FIGHT_FLIGHT;
                    } else {
                        updateMap();
                    }
                    if (checkWon()) {
                        currentGameState = gameState.WIN;
                    }
                } else if (input.equals("c")) {
                    savePlayer();
                } else if (input.equals("q")) {
                    currentGameState = gameState.QUIT;
                }
                // Save / Quit
                break;

            case FIGHT_FLIGHT:
                // Fight / Run
                if (input.equals("f")) {
                    // FIGHT
                    // fightEnemy();
                    System.out.println("FIGHT!");
                    System.out.println(villains.size());
                    currentEnemy.setDefeated(true);
                    villains.remove(currentEnemy);
                    System.out.println(villains.size());
                    currentGameState = gameState.PLAY;
                } else if (input.equals("r")) {
                    // FLEA
                    tryFlea();
                } else if (input.equals("y")) {
                    // EQUIP ARTIFACT IF ANY
                } else if (input.equals("n")) {
                    // IGNORE ARTIFACT
                }
                // Equip / Ignore
                break;

            case NO_ESCAPE:
                // Equip / Ignore
                break;

            case GAME_OVER:
                // Quit / Restart (Start Menu)
                break;

            case WIN:
                // Continue to next map (via start screen?) / quit
                if (input.equals("r")) {
                    // Save updated array to saves.txt (overwrite existing one if any)
                    savePlayer();
                    currentGameState = gameState.START;
                } else if (input.equals("q")) {
                    currentGameState = gameState.QUIT;
                }
                break;

            default:
                System.out.println("Bad Game State");
                System.exit(0);
                // break;
        }
    }

    private void tryFlea() {
        // 65% chance to escape
        Random random = new Random();
        int chance = random.nextInt(101);
        if (chance <= 35) {
            // No escape
            System.out.println("FIGHT!");
            currentGameState = gameState.PLAY;
        } else {
            // escape
            hero.setPositionX(xBeforeMove);
            hero.setPositionY(yBeforeMove);
            currentGameState = gameState.PLAY;
        }
    }

    private void savePlayer() {
        // Add current hero to heroes from file
        if (heroes != null) {
            if (!heroes.contains(hero)) {
                heroes.add(hero);
            }

        } else {
            heroes = new ArrayList<Player>();
            heroes.add(hero);
        }
        // TODO: write current heroes array to file (overwrite)
    }

    private boolean checkWon() {
        if (hero.getPositionX() == 0 || hero.getPositionY() == 0 || hero.getPositionX() == map[0].length - 1
                || hero.getPositionY() == map[0].length - 1) {
            return (true);
        }
        return (false);
    }

    private boolean checkConflict() {
        for (Villain villain : villains) {
            if (villain.getPositionX() == hero.getPositionX() && villain.getPositionY() == hero.getPositionY()) {
                currentEnemy = villain;
                return (true);
            }
        }
        return (false);
    }

    private void movePlayer(String move) {
        // x and y seemingly reversed? Weird Java behaviour.
        xBeforeMove = hero.getPositionX();
        yBeforeMove = hero.getPositionY();

        System.out.println(String.format("Pos before move: (%d,%d)", xBeforeMove, yBeforeMove));

        if (move.equals("w")) {
            hero.setPositionX(xBeforeMove - 1);
        } else if (move.equals("a")) {
            hero.setPositionY(yBeforeMove - 1);
        } else if (move.equals("s")) {
            hero.setPositionX(xBeforeMove + 1);
        } else if (move.equals("d")) {
            hero.setPositionY(yBeforeMove + 1);
        }
    }

    private void updateMap() {
        map[hero.getPositionX()][hero.getPositionY()] = 'H';
        map[xBeforeMove][yBeforeMove] = '.';
    }

    private void initMap() {
        map = mapper.generateMap(hero.getLevel());
        villains = generateVillains(map[0].length, hero.getLevel());
        spawnVillains();

        System.out.println(String.format("Hero X: %d ; Hero Y: %d", hero.getPositionX(), hero.getPositionY()));

        // Debug map after villains spawned
        for (int i = 0; i < map[0].length; i++) {
            for (int k = 0; k < map[0].length; k++) {
                System.out.print(map[i][k]);
            }
            System.out.print("\n");
        }

        // Debug villains
        for (Villain vil : villains) {
            System.out.println(vil.toString() + " - " + vil.debugCoords());
        }
    }

    private void createHero(String input) {
        String heroClass = "";
        String heroName;

        switch (input) {
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
                System.out.println("Unrecognized Hero Class");
                System.exit(0);
        }
        heroName = display.createCharName();
        hero = PlayerFactory.newPlayer(heroName, heroClass);

        System.out.println(hero.toString());
        System.out.println(String.format("X: %d ; Y: %d", hero.getPositionX(), hero.getPositionY()));
        initMap();
    }

    public void displayState() {
        switch (currentGameState) {
            case START:
                display.startScreen();
                break;
            case CREATE:
                display.createCharClass();
                break;
            case SELECT:
                display.loadChar(heroes);
                break;
            case PLAY:
                display.playGame();
                break;
            case FIGHT_FLIGHT:
                display.fightOrFlight();
                break;
            case NO_ESCAPE:
                break;
            case GAME_OVER:
                break;
            case WIN:
                display.roundWon();
                break;
            case QUIT:
                break;

            default:
                break;
        }
    }

    private void spawnVillains() {
        Random random = new Random();

        for (Villain villain : villains) {
            int x = random.nextInt(map[0].length);
            int y = random.nextInt(map[0].length);

            if (validateSpawn(x, y)) {
                villain.setPositionX(x);
                villain.setPositionY(y);
                // TODO: Remove below line
                map[x][y] = 'V';
            } else {
                x = random.nextInt(map[0].length);
                y = random.nextInt(map[0].length);

                if (validateSpawn(x, y)) {
                    villain.setPositionX(x);
                    villain.setPositionY(y);
                    // TODO: Remove below line
                    map[x][y] = 'V';
                }
            }
        }
    }

    private boolean validateSpawn(int x, int y) {
        return (map[x][y] == '.');
    }

    private List<Villain> generateVillains(int mapSize, int level) {
        List<Villain> villains = new ArrayList<>();
        int villainCount = mapSize + 1;
        int i = 0;
        String[] villainTypes = { "Wraith", "Bandit", "Leshen", "Vampire" };
        Random random = new Random(mapSize * level);

        while (i < villainCount) {
            villains.add(new Villain(villainTypes[random.nextInt(4)], level));
            i++;
        }

        return (villains);
    }

    private List<Player> loadFromFile() {
        // TODO: Handle no file/empty file appropriately across all places where
        // <heroes> is used
        String filename = System.getProperty("user.dir") + "/saves.txt";
        List<Player> heroes = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            // String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(",");
                try {
                    Player hero = PlayerFactory.existingPlayer(splitLine[0], splitLine[1],
                            Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]),
                            Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]),
                            Integer.parseInt(splitLine[6]), splitLine[7], splitLine[8], splitLine[9]);
                    if (hero != null) {
                        heroes.add(hero);
                    }

                } catch (NumberFormatException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
            reader.close();
            System.out.println(heroes);
            return (heroes);
        } catch (FileNotFoundException e) {
            // TODO remove the stackTrace
            System.out.println(String.format("File '%s' not found, continuing", filename));
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return (null);
    }

    public void playGame() {
        display.renderGame();
    }
}

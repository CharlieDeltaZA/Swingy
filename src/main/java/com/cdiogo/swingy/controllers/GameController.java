package com.cdiogo.swingy.controllers;

import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cdiogo.swingy.File;
import com.cdiogo.swingy.models.Map;
import com.cdiogo.swingy.models.PlayerFactory;
import com.cdiogo.swingy.models.artifacts.Armour;
import com.cdiogo.swingy.models.artifacts.Artifact;
import com.cdiogo.swingy.models.artifacts.Helm;
import com.cdiogo.swingy.models.artifacts.Weapon;
import com.cdiogo.swingy.models.heroes.Player;
import com.cdiogo.swingy.models.villains.Villain;
import com.cdiogo.swingy.views.ConsoleDisplay;
import com.cdiogo.swingy.views.Display;
import com.cdiogo.swingy.views.GuiDisplay;

@Getter
@Setter
public class GameController {
    private ConsoleDisplay console = new ConsoleDisplay(this);
    private GuiDisplay gui = new GuiDisplay(this);
    private Display display;
    private Player hero;
    private Villain currentEnemy;
    private List<Player> heroes;
    private List<Villain> villains;
    private File file;

    public enum gameState {
        START, SELECT, CREATE_CLASS, CREATE_NAME, PLAY, FIGHT_FLIGHT, NO_ESCAPE, GAME_OVER, WIN, QUIT, AFTER_ACTION
    }

    private gameState currentGameState;
    private gameState stateBeforeQuit;
    private boolean gameOver;
    private boolean heroEscaped;
    private boolean levelUp;
    private boolean heroWon;
    private Map mapper;
    private char[][] map;
    private int xBeforeMove;
    private int yBeforeMove;

    private String heroClass;

    public GameController(String displayType) {
        currentGameState = gameState.START;
        stateBeforeQuit = gameState.START;
        gameOver = false;
        heroEscaped = false;
        heroWon = false;
        levelUp = false;
        mapper = new Map(this);
        file = new File();
        heroes = file.loadFromFile();

        switch (displayType) {
            case "console":
                System.out.println("Cool, lets console");
                display = console;
                break;
            case "gui":
                System.out.println("Not yet mate");
                display = gui;
                break;
            default:
                System.out.println(String.format("Display type '%s' not supported, exiting...", displayType));
                System.exit(0);
        }
    }

    public void handleInput(String input) {
        System.out.println("Input: " + input);
        switch (currentGameState) {
            case START:
                switch (input) {
                    case "c":
                        currentGameState = gameState.CREATE_CLASS;
                        break;

                    case "l":
                        currentGameState = gameState.SELECT;
                        break;

                    case "q":
                        stateBeforeQuit = gameState.START;
                        currentGameState = gameState.QUIT;
                        break;
                    
                    case "x":
                        changeDisplay();
                        display.renderGame();
                        break;

                    default:
                        System.out.println("Bad Choice - START");
                        System.exit(0);
                        // break;
                }
                break; // case START

            case CREATE_CLASS:
                if (input.equals("b")) {
                    currentGameState = gameState.START;
                    break;
                } else {
                    // createHero(input);
                    heroClass = input;
                    currentGameState = gameState.CREATE_NAME;
                }
                break;

            case CREATE_NAME:
                if (input.length() > 2) {
                    createHero(input);
                    currentGameState = gameState.PLAY;
                }
                break;

            case SELECT:
                if (input.equals("b")) {
                    currentGameState = gameState.START;
                    break;
                } else {
                    int index = Integer.parseInt(input);
                    hero = heroes.get(index - 1);
                    // System.out.println(hero.toString());
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
                        if (currentGameState == gameState.FIGHT_FLIGHT) {
                            heroWon = true;
                        } else {
                            currentGameState = gameState.WIN;
                        }
                    }
                } else if (input.equals("c")) {
                    savePlayer();
                    System.out.println("Player saved!");
                } else if (input.equals("q")) {
                    stateBeforeQuit = gameState.PLAY;
                    currentGameState = gameState.QUIT;
                }
                // Save / Quit
                break;

            case FIGHT_FLIGHT:
                // Fight / Run
                if (input.equals("f")) {
                    // FIGHT
                    fightEnemy();
                } else if (input.equals("r")) {
                    // FLEE
                    tryFlee();
                } 
                break;

            case NO_ESCAPE:
                // Forced Fight
                if (input.equals("c")) {
                    fightEnemy();
                }
                break;

            case AFTER_ACTION:
                // If hero wins, display xp gained, artifacts to equip
                if (input.equals("c") || input.equals("n")) {
                    levelUp();
                } else if (input.equals("y")) {
                    levelUp();
                    equipArtifact();
                }
                if (heroWon == true) {
                    currentGameState = gameState.WIN;
                } else {
                    currentGameState = gameState.PLAY;
                }
                break;

            case GAME_OVER:
                // Quit / Restart (Start Menu)
                if (input.equals("r")) {
                    savePlayer();
                    currentGameState = gameState.START;
                } else if (input.equals("q")) {
                    stateBeforeQuit = gameState.GAME_OVER;
                    currentGameState = gameState.QUIT;
                }
                break;

            case WIN:
                // Continue to next map (via start screen?) / quit
                if (input.equals("r")) {
                    // Save updated array to saves.txt (overwrite existing one if any)
                    savePlayer();
                    heroWon = false;
                    currentGameState = gameState.START;
                } else if (input.equals("q")) {
                    stateBeforeQuit = gameState.WIN;
                    currentGameState = gameState.QUIT;
                }
                break;
            
            case QUIT:
                if (input.equals("y")) {
                    if (hero != null) {
                        savePlayer();
                    }
                    gameOver = true;
                    System.exit(0);
                } else if (input.equals("n")) {
                    currentGameState = stateBeforeQuit;
                }
                break;

            default:
                gameOver = true;
                System.out.println("Bad Game State");
                System.exit(0);
                // break;
        }
    }

    private void levelUp() {
        int newXp = hero.getXp() + currentEnemy.getXp();
        int levelThresh = (hero.getLevel() * 1000 + (int)Math.pow((double)hero.getLevel() - 1, 2.0) * 450);
        System.out.println("newXp: "+newXp);
        System.out.println("LevelThresh: "+levelThresh);

        if (newXp >= levelThresh) {
            levelUp = true;
            hero.setLevel(hero.getLevel() + 1);
            hero.setXp(newXp);
        } else {
            hero.setXp(newXp);
        }
    }

    private void equipArtifact() {
        Artifact enemyArt = currentEnemy.getArtifact();

        if (enemyArt instanceof Weapon) {
            hero.setWeapon(new Weapon(enemyArt.getArtifactName()));
        } else if (enemyArt instanceof Armour) {
            hero.setArmour(new Armour(enemyArt.getArtifactName()));
        } else if (enemyArt instanceof Helm) {
            hero.setHelm(new Helm(enemyArt.getArtifactName()));
        }
    }

    private void fightEnemy() {
        System.out.println("FIGHT!");
        System.out.println(villains.size());
        Random rand = new Random();

        int heroInit = rand.nextInt(21);
        int enemyInit = rand.nextInt(21);

        int heroEffectiveAtk = hero.getAttack() + hero.getWeapon().getArtifactValue();
        int heroEffectiveDef = hero.getDefense() + hero.getArmour().getArtifactValue();
        int heroEffectiveHp = hero.getHp() + hero.getHelm().getArtifactValue();

        int enemyEffectiveAtk = currentEnemy.getAttack();
        int enemyEffectiveDef = currentEnemy.getDefense();
        int enemyEffectiveHp = currentEnemy.getHp();

        if (currentEnemy.getArtifact() != null) {
            switch (currentEnemy.getArtifact().getArtifactTrait()) {
                case "Atk":
                    enemyEffectiveAtk += currentEnemy.getArtifact().getArtifactValue();
                    break;
                case "Def":
                    enemyEffectiveDef += currentEnemy.getArtifact().getArtifactValue();
                    break;
                case "HP":
                    enemyEffectiveHp += currentEnemy.getArtifact().getArtifactValue();
                    break;
            }
            // System.out.println(currentEnemy.getArtifact().toString());
        }

        System.out.println("");
        System.out.println(String.format("HeroInit: %d ; EnemyInit: %d", heroInit, enemyInit));
        System.out.println(String.format("effHP: %d ; effAtk: %d ; effDef: %d ;", heroEffectiveHp, heroEffectiveAtk, heroEffectiveDef));
        System.out.println(String.format("ENEMYeffHP: %d ; ENEMYeffAtk: %d ; ENEMYeffDef: %d ;", enemyEffectiveHp, enemyEffectiveAtk, enemyEffectiveDef));

        while (heroEffectiveHp > 0 && enemyEffectiveHp > 0) {
            System.out.println("---------------------");
            System.out.println("Hero: " + heroEffectiveHp);
            System.out.println("Enemy: " + enemyEffectiveHp);
            if (heroInit >= enemyInit) {
                // Hero Attacks first
                System.out.println("Hero Attacks first");
                enemyEffectiveHp -= heroEffectiveAtk;
                heroEffectiveHp -= enemyEffectiveAtk;
                
            } else {
                // Enemy Attacks first
                System.out.println("Enemy Attacks first");
                heroEffectiveHp -= enemyEffectiveAtk;
                enemyEffectiveHp -= heroEffectiveAtk;
            }
        }
        // currentEnemy.setDefeated(true);
        // villains.remove(currentEnemy);
        System.out.println("");
        System.out.println(String.format("HeroInit: %d ; EnemyInit: %d", heroInit, enemyInit));
        System.out.println(String.format("effHP: %d ; effAtk: %d ; effDef: %d ;", heroEffectiveHp, heroEffectiveAtk, heroEffectiveDef));
        System.out.println(String.format("ENEMYeffHP: %d ; ENEMYeffAtk: %d ; ENEMYeffDef: %d ;", enemyEffectiveHp, enemyEffectiveAtk, enemyEffectiveDef));
        // updateMap();
        // currentGameState = gameState.AFTER_ACTION;
        if (heroEffectiveHp <= 0) {
            currentGameState = gameState.GAME_OVER;
        } else if (enemyEffectiveHp <= 0) {
            currentEnemy.setDefeated(true);
            villains.remove(currentEnemy);
            System.out.println(villains.size());
            
            updateMap();
            currentGameState = gameState.AFTER_ACTION;
        }
    }

    private void tryFlee() {
        // 50% chance to escape
        Random random = new Random();
        int chance = random.nextInt(101);
        if (chance <= 50) {
            // No escape
            currentGameState = gameState.NO_ESCAPE;
        } else {
            // escape
            hero.setPositionX(xBeforeMove);
            hero.setPositionY(yBeforeMove);
            heroEscaped = true;
            currentGameState = gameState.PLAY;
        }
    }

    private void changeDisplay() {
        if (display instanceof ConsoleDisplay) {
            display = gui;
        } else {
            display = console;
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
        for (Player hero : heroes) {
            String heroString = String.format("%s,%s,%d,%d,%d,%d,%d,%s,%s,%s\n",
                hero.getHeroName(), hero.getHeroClass(), hero.getLevel(), hero.getXp(),
                hero.getHp(), hero.getAttack(), hero.getDefense(), hero.getWeapon().getArtifactName(),
                hero.getArmour().getArtifactName(), hero.getHelm().getArtifactName());
            file.addLine(heroString);
        }
        file.saveFile();
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

    private void createHero(String heroName) {
        // String heroClass = "";
        // String heroName;

        switch (heroClass) {
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
        // heroName = display.createCharName();
        hero = PlayerFactory.newPlayer(heroName, heroClass);

        System.out.println(hero.toString());
        System.out.println(String.format("X: %d ; Y: %d", hero.getPositionX(), hero.getPositionY()));
        initMap();
    }

    public void displayState() {
        System.out.println("CURRENT GAME STATE : " + currentGameState);
        switch (currentGameState) {
            case START:
                display.startScreen();
                break;
            case CREATE_CLASS:
                display.createCharClass();
                break;
            case CREATE_NAME:
                display.createCharName();
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
                display.noEscape();
                break;
            case AFTER_ACTION:
                display.afterAction();
                break;
            case GAME_OVER:
                display.gameOver();
                break;
            case WIN:
                display.roundWon();
                break;
            case QUIT:
                display.quitGame();
                break;

            default:
                gameOver = true;
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
        return (map[x][y] == '*');
    }

    private Artifact generateArtifact() {
        String[] artifactTypes = { "Weapon", "Armour", "Helm" };
        String[] weaponTypes = { "Great Axe", "Short Bow", "Magic Missle", "Dagger", "Silver Sword" };
        String[] armourTypes = { "Leather Armour", "Chainmail", "Quen", "Knights Armour", "Shield" };
        String[] helmTypes = { "Balaclava", "Crown", "Wizards Hat" };
        Random random = new Random();
        
        String artifactType = artifactTypes[random.nextInt(3)];
        switch (artifactType) {
            case "Weapon":
                // System.out.println("Generating weapon");
                return (new Weapon(weaponTypes[random.nextInt(5)]));
                // break;
            case "Armour":
                // System.out.println("Generating armour");
                return (new Armour(armourTypes[random.nextInt(5)]));
                // break;
            case "Helm":
                // System.out.println("Generating helm");
                return (new Helm(helmTypes[random.nextInt(3)]));
                // break;
            
            default:
                System.out.println("Something went wrong generating artifact, returning null");
                return (null);
                // break;
        }

        // return (null);
    }
    
    private List<Villain> generateVillains(int mapSize, int level) {
        List<Villain> villains = new ArrayList<>();
        Villain villain;
        int villainCount = mapSize + 1;
        int i = 0;
        String[] villainTypes = { "Wraith", "Bandit", "Leshen", "Vampire" };
        Random random = new Random(mapSize * level);
        
        while (i < villainCount) {
            int artifactChance = random.nextInt(101);
            // System.out.println("Artifact Chance: " + artifactChance);
            // 20% chance a villain has an artifact
            villain = new Villain(villainTypes[random.nextInt(4)], level);
            if (artifactChance >= 80) {
                villain.setArtifact(generateArtifact());
                System.out.println(String.format("Artifact Generated :: %s", villain.getArtifact().toString()));
            } else {
                villain.setArtifact(null);
            }
            villains.add(villain);
            i++;
        }

        return (villains);
    }

    public void playGame() {
        display.renderGame();
    }
}

package com.cdiogo.swingy.views;

import java.util.List;

import com.cdiogo.swingy.controllers.GameController;
import com.cdiogo.swingy.models.heroes.Player;
import com.cdiogo.swingy.models.villains.Villain;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;

public class GuiDisplay implements Display {

    private GameController controller;
    private boolean initialized = false;
    private JFrame frame;
    private JPanel panel;

    private JButton backBtn = new JButton("Back");
    private JButton saveBtn = new JButton("Save");
    private JButton equipBtn = new JButton("Equip");
    private JButton ignoreBtn = new JButton("Ignore");
    private JButton menuBtn = new JButton("Return to Menu");
    private JButton upBtn = new JButton("North");
    private JButton downBtn = new JButton("South");
    private JButton rightBtn = new JButton("East");
    private JButton leftBtn = new JButton("West");
    private JButton quitBtn = new JButton("Quit");
    private JButton quitConfirmBtn = new JButton("Confirm");
    private JButton quitDenyBtn = new JButton("Deny");
    private JButton fightBtn = new JButton("Fight");
    private JButton fleeBtn = new JButton("Flee");
    private JButton continueBtn = new JButton("Continue");
    private JButton createBtn = new JButton("Create Hero");
    private JButton loadBtn = new JButton("Load Hero");
    private JButton submitClassBtn = new JButton("Submit"); // class index
    private JButton submitIndexBtn = new JButton("Submit"); // saved hero index
    private JButton submitNameBtn = new JButton("Submit"); // name
    private JButton displayBtn = new JButton("Switch View");

    private JSpinner classSelect = new JSpinner();
    private JSpinner heroSelect = new JSpinner();

    private JTextPane welcomeText = new JTextPane();
    private JTextPane heroStatsText = new JTextPane();
    private JTextPane mapText = new JTextPane();
    private JTextArea characterText = new JTextArea();
    private JTextArea messageText = new JTextArea();
    private JLabel nameLabel = new JLabel("Name: (2 char min)");
    private JTextField heroNameText = new JTextField();

    public GuiDisplay(GameController controller) {
        this.controller = controller;

        // Eclipse GUI Builder debugging below //

        // generateGui();
        // initCommonComponents();
        // configureActionListeners();

        // Uncomment only 1 of the below functions to render that screen

        // startScreen();
        // createCharName();
        // createCharClass();
        // loadChar(controller.getHeroes()); //some missing comps due to logic
        // playGame();
        // fightOrFlight();
        // noEscape();
        // roundWon();
        // gameOver();
        // afterAction(); // some missing buttons due to logic
        // quitGame();

    }

    // Init common components that will be used frequently and probably don't need
    // updating at any point
    private void initCommonComponents() {
        // welcome to Swingy text
        welcomeText.setBackground(Color.LIGHT_GRAY);
        welcomeText.setText(
                "\r\n   WELCOME TO\r\n         _____          _                   \r\n        /  ___|        (_)                  \r\n        \\ `--.__      ___ _ __   __ _ _   _ \r\n         `--. \\ \\ /\\ / / | '_ \\ / _` | | | |\r\n        /\\__/ /\\ V  V /| | | | | (_| | |_| |\r\n        \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |\r\n                                 __/ | __/ |\r\n                                |___/ |___/ \r\n\r\n\r\n");
        welcomeText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        welcomeText.setEditable(false);
        welcomeText.setBounds(10, 11, 352, 193);
        welcomeText.setMargin(new Insets(10, 10, 10, 10));

        // Start Screen Buttons
        createBtn.setBounds(10, 215, 125, 23);
        loadBtn.setBounds(145, 215, 125, 23);
        quitBtn.setBounds(292, 215, 65, 23);
        displayBtn.setBounds(10, 249, 125, 23);
        createBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        loadBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        quitBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        displayBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));

        // Load Char | CharClass | CharName components
        characterText.setWrapStyleWord(true);
        characterText.setLineWrap(true);
        characterText.setBackground(Color.LIGHT_GRAY);
        characterText.setFont(new Font("Monospaced", Font.PLAIN, 13));
        characterText.setEditable(false);
        characterText.setBounds(395, 11, 319, 193);
        characterText.setMargin(new Insets(10, 10, 10, 10));
        submitIndexBtn.setBounds(277, 215, 85, 23);
        submitClassBtn.setBounds(277, 215, 85, 23);
        submitNameBtn.setBounds(277, 227, 85, 23);
        backBtn.setBounds(10, 215, 75, 23);
        submitIndexBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        submitClassBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        submitNameBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        backBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        heroSelect.setBounds(175, 215, 92, 23);
        classSelect.setModel(new SpinnerNumberModel(1, 1, 4, 1));
        classSelect.setBounds(175, 215, 92, 23);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(15, 210, 140, 14);
        heroNameText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        heroNameText.setBounds(10, 228, 159, 20);
        heroNameText.setColumns(10);

        // Play
        mapText.setEditable(false);
        mapText.setBackground(Color.LIGHT_GRAY);
        mapText.setBounds(230, 11, 768, 707);
        mapText.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mapText.setMargin(new Insets(2, 2, 2, 2));
        messageText.setFont(new Font("Monospaced", Font.PLAIN, 12));
        messageText.setWrapStyleWord(true);
        messageText.setLineWrap(true);
        messageText.setEditable(false);
        messageText.setBackground(Color.LIGHT_GRAY);
        messageText.setBounds(10, 11, 210, 88);
        messageText.setMargin(new Insets(5, 5, 5, 5));
        upBtn.setBounds(80, 260, 70, 23);
        downBtn.setBounds(80, 290, 70, 23);
        leftBtn.setBounds(10, 290, 65, 23);
        rightBtn.setBounds(155, 290, 65, 23);
        saveBtn.setBounds(10, 420, 70, 23);
        upBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        downBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        leftBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        rightBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        saveBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        heroStatsText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        heroStatsText.setEditable(false);
        heroStatsText.setBackground(Color.LIGHT_GRAY);
        heroStatsText.setBounds(10, 110, 210, 135);
        heroStatsText.setMargin(new Insets(5, 5, 5, 5));

        // FightFlight
        fightBtn.setBounds(10, 120, 70, 23);
        fleeBtn.setBounds(10, 152, 70, 23);
        fightBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        fleeBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));

        // RoundWon
        menuBtn.setBounds(10, 165, 135, 23);
        menuBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));

        // QuitGame
        quitConfirmBtn.setBounds(10, 152, 90, 23);
        quitDenyBtn.setBounds(120, 152, 90, 23);
        quitConfirmBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        quitDenyBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));

        // NoEscape
        continueBtn.setSize(90, 23);
        continueBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));

        // GameOver

        // AfterAction
        equipBtn.setBounds(10, 226, 90, 23);
        ignoreBtn.setBounds(130, 226, 90, 23);
        equipBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));
        ignoreBtn.setFont(new Font("Monospaced", Font.PLAIN, 11));

    }

    private void configureActionListeners() {

        createBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("c");
                controller.displayState();
            }
        });

        loadBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("l");
                controller.displayState();
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("b");
                controller.displayState();
            }
        });

        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("q");
                controller.displayState();
            }
        });

        quitConfirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("y");
                controller.displayState();
            }
        });

        quitDenyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("n");
                controller.displayState();
            }
        });

        submitClassBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    classSelect.commitEdit();
                } catch (ParseException err) {
                    // TODO Auto-generated catch block
                    err.printStackTrace();
                }
                int index = (int)classSelect.getValue();
                controller.handleInput(Integer.toString(index));
                controller.displayState();
            }
        });

        submitNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = heroNameText.getText();

                if (!(name.equals("")) || name.length() >= 2) {
                    controller.handleInput(name);
                    controller.displayState();
                }
            }
        });

        submitIndexBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    heroSelect.commitEdit();
                } catch (ParseException err) {
                    // TODO Auto-generated catch block
                    err.printStackTrace();
                }
                int index = (int)heroSelect.getValue();
                controller.handleInput(Integer.toString(index));
                controller.displayState();
            }
        });

        upBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("w");
                controller.displayState();
            }
        });

        downBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("s");
                controller.displayState();
            }
        });

        rightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("d");
                controller.displayState();
            }
        });

        leftBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("a");
                controller.displayState();
            }
        });

        fightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("f");
                controller.displayState();
            }
        });

        fleeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("r");
                controller.displayState();
            }
        });

        continueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("c");
                controller.displayState();
            }
        });

        equipBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("y");
                controller.displayState();
            }
        });

        ignoreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("n");
                controller.displayState();
            }
        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("c");
                controller.displayState();
            }
        });

        menuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("r");
                controller.displayState();
            }
        });

        displayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput("x");
                controller.displayState();
            }
        });
	}

    private void generateGui() {
        frame = new JFrame();
        panel = new JPanel();

        frame.setTitle("Swingy - cdiogo");
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        initCommonComponents();
        configureActionListeners();
    }
    
    @Override
    public void startScreen() {
        panel.removeAll();        
        
        quitBtn.setLocation(292, 215);
        displayBtn.setLocation(10, 249);
        panel.add(createBtn);
        panel.add(loadBtn);
        panel.add(quitBtn);
        panel.add(welcomeText);
        panel.add(displayBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void createCharName() {
        panel.removeAll();
        
        characterText.setText("\r\n\r\n   Enter a name for your Hero");
        characterText.setSize(319, 193);
        panel.add(characterText);
        panel.add(welcomeText);
        panel.add(submitNameBtn);
        panel.add(heroNameText);
        panel.add(nameLabel);

        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void createCharClass() {
        panel.removeAll();
        
        characterText.setText("\r\n\r\n   Choose a Hero Class\r\n\r\n      1 - Ranger\r\n      2 - Wizard\r\n      3 - Fighter\r\n      4 - Rogue");
        characterText.setSize(319, 193);
        panel.add(characterText);
        panel.add(welcomeText);
        panel.add(classSelect);
        panel.add(backBtn);
        panel.add(submitClassBtn);

        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void loadChar(List<Player> heroes) {
        panel.removeAll();
        
        characterText.setSize(319, 420);
        displayHeroes(heroes);
        panel.add(welcomeText);
        panel.add(characterText);
        panel.add(backBtn);

        if (heroes.size() != 0) {
            heroSelect.setModel(new SpinnerNumberModel(1, 1, heroes.size(), 1));
            panel.add(submitIndexBtn);
            panel.add(heroSelect);
        }
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    private void displayHeroes(List<Player> heroes) {
        String line = "\r\n\r\n   Choose a Hero\n\n";
        int i = 1;

        if (heroes.size() != 0) {
            for (Player hero : heroes) {
                line += String.format("  %d - %s : %s\n", i, hero.getHeroName(), hero.getHeroClass());
                i++;
            }
        } else {
            line += "\tNo Saved Heroes found!\n";
            line += "\tTry creating one instead.";
        }
        characterText.setText(line);
    }

    @Override
    public void renderGame() {
        if (!initialized) {
            generateGui();
            initialized = true;
        }
        controller.displayState();
    }

    @Override
    public void playGame() {
        panel.removeAll();
        
        printMap();
        messageText.setBounds(10, 11, 210, 88);
        messageText.setText("Reach the edge of the map to win the current mission.\n\nEnemies may be encountered!");
        if (controller.isHeroEscaped()) {
            controller.setHeroEscaped(false);
            messageText.setText("You have successfully escaped!");
        }
        if (controller.isLevelUp()) {
            controller.setLevelUp(false);
            messageText.setText("You have levelled up!");
        }
        if (controller.isSaved()) {
            controller.setSaved(false);
            messageText.setText("Player Saved!");
        }
        quitBtn.setLocation(155, 454);
        displayBtn.setLocation(10, 454);
        heroStatsText.setText(controller.getHero().toString());
        panel.add(mapText);
        panel.add(messageText);
        panel.add(upBtn);
        panel.add(downBtn);
        panel.add(leftBtn);
        panel.add(rightBtn);
        panel.add(quitBtn);
        panel.add(saveBtn);
        panel.add(displayBtn);
        panel.add(heroStatsText);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    private void printMap() {
        char[][] map;
        String line = "";

        map = controller.getMap();

        for (int i = 0; i < map[0].length; i++) {
            line += " ";
            for (int k = 0; k < map[0].length; k++) {
                line += map[i][k];
                if (map[0].length < 45) {
                    line += " ";
                }
            }
            line += "\n";
        }
        
        mapText.setText(line);
    }

    @Override
    public void fightOrFlight() {
        String line = "";
        panel.removeAll();
        
        printMap();
        line = String.format("You have encountered a villain!\n\n%s", controller.getCurrentEnemy().toString());
        messageText.setText(line);
        messageText.setBounds(10, 11, 210, 98);
        panel.add(mapText);
        panel.add(messageText);
        panel.add(fightBtn);
        panel.add(fleeBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void roundWon() {
        panel.removeAll();
        
        printMap();
        messageText.setText("You have Successfully completed this level!\r\n\r\nContinue your adventure from the main menu, or try a new character.");
        messageText.setBounds(10, 11, 210, 138);
        quitBtn.setLocation(155, 165);
        panel.add(messageText);
        panel.add(mapText);
        panel.add(quitBtn);
        panel.add(menuBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void quitGame() {
        panel.removeAll();
        
        messageText.setText("Are you sure you would like to quit the game?\r\n\r\nConfirm - Save and Quit\r\nDeny - Return to previous screen");
        messageText.setBounds(10, 11, 200, 130);
        panel.add(messageText);
        panel.add(quitConfirmBtn);
        panel.add(quitDenyBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void noEscape() {
        panel.removeAll();
        
        printMap();
        messageText.setText("Your attempt to flee has failed!\r\n\r\nPrepare for BATTLE!");
        messageText.setBounds(10, 11, 210, 88);
        continueBtn.setLocation(10, 110);
        panel.add(messageText);
        panel.add(mapText);
        panel.add(continueBtn);
                
        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void gameOver() {
        panel.removeAll();
        
        printMap();
        messageText.setText("       GAME   OVER\r\n\r\nYour hero has died :(\r\n\r\nYou may return to the menu and play again, or you may quit.");
        messageText.setBounds(10, 11, 210, 142);
        quitBtn.setLocation(155, 165);
        panel.add(mapText);
        panel.add(messageText);
        panel.add(quitBtn);
        panel.add(menuBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void afterAction() {
        Villain enemy = controller.getCurrentEnemy();
        String line = "";
        panel.removeAll();
        
        printMap();
        messageText.setBounds(10, 11, 210, 170);
        continueBtn.setLocation(10, 192);
        panel.add(mapText);
        panel.add(messageText);
        
        line += String.format("You have defeated the %s\n", enemy.getName());
        line += String.format("You gain %d XP\n", enemy.getXp());
        if (enemy.getArtifact() != null) {
            line += String.format("\n\nThis villain dropped an artifact!\n%s", enemy.getArtifact().toString());
            line += "\n\nWould you like to equip it?";
            messageText.setText(line);
            panel.add(equipBtn);
            panel.add(ignoreBtn);
        } else {
            messageText.setText(line);
            panel.add(continueBtn);
        }
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    public void hideFrame() {
        frame.setVisible(false);
    }
}

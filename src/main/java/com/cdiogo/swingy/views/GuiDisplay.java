package com.cdiogo.swingy.views;

import java.util.List;

import com.cdiogo.swingy.controllers.GameController;
import com.cdiogo.swingy.models.heroes.Player;
import com.cdiogo.swingy.models.villains.Villain;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
    private JButton createBtn = new JButton("Create Character");
    private JButton loadBtn = new JButton("Load Character");
    private JButton submitClassBtn = new JButton("Submit"); // class index
    private JButton submitIndexBtn = new JButton("Submit"); // saved hero index
    private JButton submitNameBtn = new JButton("Submit"); // name
    private JButton displayBtn = new JButton("Switch to Console");

    private JSpinner classSelect = new JSpinner();
    private JSpinner heroSelect = new JSpinner();

    private JTextPane welcomeText = new JTextPane();
    private JTextPane heroStatsText = new JTextPane();
    private JTextArea characterText = new JTextArea();
    private JTextPane mapText = new JTextPane();
    private JTextArea messageText = new JTextArea();
    private JTextField heroNameText = new JTextField();
    private JLabel nameLabel = new JLabel("Name: (2 char min)");

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

    // Init common components that will be used frequently and probably don't need updating at any point
    private void initCommonComponents() {
        // welcome to Swingy text
        welcomeText.setBackground(Color.LIGHT_GRAY);
        welcomeText.setText("\r\n   WELCOME TO                                  \r\n         _____          _                   \r\n        /  ___|        (_)                  \r\n        \\ `--.__      ___ _ __   __ _ _   _ \r\n         `--. \\ \\ /\\ / / | '_ \\ / _` | | | |\r\n        /\\__/ /\\ V  V /| | | | | (_| | |_| |\r\n        \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |\r\n                                 __/ | __/ |\r\n                                |___/ |___/ \r\n\r\n\r\n");
        welcomeText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        welcomeText.setEditable(false);
        welcomeText.setBounds(10, 11, 352, 193);
        welcomeText.setMargin(new Insets(10, 10, 10, 10));

        // Start Screen Buttons
        createBtn.setBounds(10, 215, 135, 23);
        loadBtn.setBounds(155, 215, 135, 23);
        quitBtn.setBounds(302, 215, 60, 23);
        displayBtn.setBounds(222, 245, 140, 23);

        // Load Char | CharClass | CharName components
        characterText.setWrapStyleWord(true);
        characterText.setLineWrap(true);
        characterText.setBackground(Color.LIGHT_GRAY);
        characterText.setFont(new Font("Monospaced", Font.PLAIN, 13));
        characterText.setEditable(false);
        characterText.setBounds(395, 11, 319, 325);
        characterText.setMargin(new Insets(10, 10, 10, 10));
        submitIndexBtn.setBounds(277, 215, 85, 23);
        submitClassBtn.setBounds(277, 215, 85, 23);
        submitNameBtn.setBounds(277, 215, 85, 23);
        backBtn.setBounds(20, 215, 60, 23);
        heroSelect.setBounds(175, 215, 92, 23);
        classSelect.setModel(new SpinnerNumberModel(1, 1, 4, 1));
        classSelect.setBounds(175, 215, 92, 23);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(20, 203, 140, 14);
        heroNameText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        heroNameText.setBounds(20, 216, 159, 20);
        heroNameText.setColumns(10);
        
        // Play
        mapText.setEditable(false);
        mapText.setBackground(Color.LIGHT_GRAY);
        mapText.setBounds(10, 11, 485, 485);
        mapText.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mapText.setMargin(new Insets(2, 2, 2, 2));
        messageText.setFont(new Font("Monospaced", Font.PLAIN, 12));
        messageText.setWrapStyleWord(true);
        messageText.setLineWrap(true);
        messageText.setEditable(false);
        messageText.setBackground(Color.LIGHT_GRAY);
        messageText.setBounds(505, 11, 209, 88);
        messageText.setMargin(new Insets(5, 5, 5, 5));
        upBtn.setBounds(580, 256, 60, 23);
        downBtn.setBounds(580, 286, 60, 23);
        leftBtn.setBounds(505, 286, 60, 23);
        rightBtn.setBounds(654, 286, 60, 23);
        saveBtn.setBounds(505, 443, 60, 23);
        heroStatsText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        heroStatsText.setEditable(false);
        heroStatsText.setBackground(Color.LIGHT_GRAY);
        heroStatsText.setBounds(505, 110, 209, 135);
        heroStatsText.setMargin(new Insets(5, 5, 5, 5));

        // FightFlight
        fightBtn.setBounds(505, 120, 60, 23);
        fleeBtn.setBounds(505, 152, 60, 23);

        // RoundWon
        menuBtn.setBounds(505, 473, 120, 23);

        // QuitGame
        quitConfirmBtn.setBounds(10, 152, 90, 23);
        quitDenyBtn.setBounds(120, 152, 90, 23);

        // NoEscape
        continueBtn.setSize(90, 23);

        // GameOver

        // AfterAction
        equipBtn.setBounds(505, 226, 90, 23);
        ignoreBtn.setBounds(605, 226, 90, 23);

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
        frame.setSize(740, 548);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        initCommonComponents();
        configureActionListeners();
    }
    
    @Override
    public void startScreen() {
        // TODO Auto-generated method stub
        panel.removeAll();        
        
        quitBtn.setLocation(302, 215);
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
        // TODO Auto-generated method stub
        panel.removeAll();
        
        panel.add(welcomeText);
        panel.add(submitNameBtn);
        characterText.setText("\r\n\r\n   Enter a name for your Hero");
        panel.add(characterText);
        panel.add(heroNameText);
        panel.add(nameLabel);

        panel.validate();
        panel.repaint();
        
        frame.setVisible(true);
     
    }

    @Override
    public void createCharClass() {
        // TODO Auto-generated method stub
        panel.removeAll();
        panel.add(welcomeText);
        
        panel.add(classSelect);
        panel.add(backBtn);
        panel.add(submitClassBtn);
        
        characterText.setText("\r\n\r\n   Choose a Hero Class\r\n\r\n      1 - Ranger\r\n      2 - Wizard\r\n      3 - Fighter\r\n      4 - Rogue");
        panel.add(characterText);

        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void loadChar(List<Player> heroes) {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        panel.add(welcomeText);
        
        displayHeroes(heroes);
        panel.add(characterText);
        
        if (heroes.size() != 0) {
            panel.add(submitIndexBtn);
            
            heroSelect.setModel(new SpinnerNumberModel(1, 1, heroes.size(), 1));
            panel.add(heroSelect);
        }
        
        panel.add(backBtn);
        
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
            line += "\tTry creating one instead";
        }

        characterText.setText(line);
    }

    @Override
    public void renderGame() {
        // TODO Auto-generated method stub
        if (!initialized) {
                generateGui();
                initialized = true;
        }
        controller.displayState();
    }

    @Override
    public void playGame() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        printMap();
        panel.add(mapText);
        
        messageText.setBounds(505, 11, 209, 88);
        messageText.setText("Reach the edge of the map to win the current mission.\n\nEnemies may be encountered!");
        if (controller.isHeroEscaped()) {
            controller.setHeroEscaped(false);
            messageText.setText("You have successfully escaped!");
        }
        if (controller.isLevelUp()) {
            controller.setLevelUp(false);
            messageText.setText("You have levelled up!");
        }
        quitBtn.setLocation(654, 473);
        displayBtn.setLocation(505, 473);
        panel.add(messageText);
        panel.add(upBtn);
        panel.add(downBtn);
        panel.add(leftBtn);
        panel.add(rightBtn);
        panel.add(quitBtn);
        panel.add(saveBtn);
        panel.add(displayBtn);
        
        heroStatsText.setText(controller.getHero().toString());
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
                if (map[0].length < 35) {
                    line += " ";
                }
            }
            line += "\n";
        }
        
        mapText.setText(line);
    }

    @Override
    public void fightOrFlight() {
        // TODO Auto-generated method stub
        String line = "";
        panel.removeAll();
        
        printMap();
        panel.add(mapText);
        
        line = String.format("You have encountered a villain!\n\n%s", controller.getCurrentEnemy().toString());
        messageText.setText(line);
        messageText.setBounds(505, 11, 209, 98);
        panel.add(messageText);
        panel.add(fightBtn);
        panel.add(fleeBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void roundWon() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        printMap();
        panel.add(mapText);
        
        messageText.setText("You have Successfully completed this level!\r\n\r\nContinue your adventure from the main menu, or try a new character.");
        messageText.setBounds(505, 11, 209, 138);
        panel.add(messageText);
        quitBtn.setLocation(635, 473);
        
        panel.add(quitBtn);
        panel.add(menuBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);

    }

    @Override
    public void quitGame() {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        panel.removeAll();
        
        printMap();
        panel.add(mapText);
        
        messageText.setText("Your attempt to flee has failed!\r\n\r\nPrepare for BATTLE!");
        messageText.setBounds(505, 11, 209, 88);
        panel.add(messageText);
        continueBtn.setLocation(505, 110);
        panel.add(continueBtn);
                
        panel.validate();
        panel.repaint();
        frame.setVisible(true);

    }

    @Override
    public void gameOver() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        printMap();
        panel.add(mapText);
        
        messageText.setText("       GAME   OVER\r\n\r\nYour hero has died :(\r\n\r\nYou may return to the menu and play again, or you may quit.");
        messageText.setBounds(505, 11, 209, 142);
        panel.add(messageText);
        quitBtn.setLocation(654, 473);
      
        panel.add(quitBtn);
        panel.add(menuBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);

    }

    @Override
    public void afterAction() {
        // TODO Auto-generated method stub
        Villain enemy = controller.getCurrentEnemy();
        String line = "";
        panel.removeAll();
        
        printMap();
        panel.add(mapText);
        
        messageText.setBounds(505, 11, 209, 170);
        panel.add(messageText);
        
        continueBtn.setLocation(505, 192);
        
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

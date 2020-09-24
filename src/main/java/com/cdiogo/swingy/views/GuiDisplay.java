package com.cdiogo.swingy.views;

import java.util.List;

import com.cdiogo.swingy.controllers.GameController;
import com.cdiogo.swingy.models.heroes.Player;
import com.cdiogo.swingy.models.villains.Villain;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GuiDisplay implements Display {

    GameController controller;
    JFrame frame;
    JPanel panel;

    JButton backBtn = new JButton("Back");
    JButton saveBtn = new JButton("Save");
    JButton equipBtn = new JButton("Equip");
    JButton ignoreBtn = new JButton("Ignore");
    JButton menuBtn = new JButton("Return to Menu");
    JButton upBtn = new JButton("North");
    JButton downBtn = new JButton("South");
    JButton rightBtn = new JButton("East");
    JButton leftBtn = new JButton("West");
    JButton quitBtn = new JButton("Quit");
    JButton quitConfirmBtn = new JButton("Confirm");
    JButton quitDenyBtn = new JButton("Deny");
    JButton fightBtn = new JButton("Fight");
    JButton fleeBtn = new JButton("Flee");
    JButton continueBtn = new JButton("Continue");
    JButton createBtn = new JButton("Create Character");
    JButton loadBtn = new JButton("Load Character");
    JButton submitClassBtn = new JButton("Submit"); // class index
    JButton submitIndexBtn = new JButton("Submit"); // saved hero index
    JButton submitNameBtn = new JButton("Submit"); // name

    JSpinner classSelect = new JSpinner();
    JSpinner heroSelect = new JSpinner();

    private final JTextPane welcomeText = new JTextPane();
    private final JTextPane heroStatsText = new JTextPane();
    JTextArea characterText = new JTextArea();
    JTextPane mapText = new JTextPane();
    JTextArea messageText = new JTextArea();
    JTextField heroNameText = new JTextField();
    JLabel nameLabel = new JLabel("Name: (2 char min)");

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

        // Start Screen Buttons
        createBtn.setSize(135, 23);
        createBtn.setLocation(10, 215);
        loadBtn.setSize(135, 23);
        loadBtn.setLocation(155, 215);
        quitBtn.setSize(60, 23);
        quitBtn.setLocation(302, 215);

        // Load Char | CharClass | CharName components
        characterText.setWrapStyleWord(true);
        characterText.setLineWrap(true);
        characterText.setBackground(Color.LIGHT_GRAY);
        characterText.setFont(new Font("Monospaced", Font.PLAIN, 13));
        characterText.setEditable(false);
        characterText.setBounds(395, 11, 300, 325);
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
        messageText.setWrapStyleWord(true);
        messageText.setLineWrap(true);
        messageText.setEditable(false);
        messageText.setBackground(Color.LIGHT_GRAY);
        messageText.setBounds(505, 11, 190, 88);
        upBtn.setSize(60, 23);
        upBtn.setLocation(570, 256);
        downBtn.setSize(60, 23);
        downBtn.setLocation(570, 286);
        leftBtn.setLocation(505, 286);
        leftBtn.setSize(60, 23);
        rightBtn.setLocation(635, 286);
        rightBtn.setSize(60, 23);
        saveBtn.setLocation(505, 473);
        saveBtn.setSize(60, 23);
        heroStatsText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        heroStatsText.setEditable(false);
        heroStatsText.setBackground(Color.LIGHT_GRAY);
        heroStatsText.setBounds(505, 110, 190, 115);
        
        // FightFlight
        fightBtn.setLocation(505, 110);
        fightBtn.setSize(60, 23);
        fleeBtn.setLocation(505, 140);
        fleeBtn.setSize(60, 23);
        
        // RoundWon
        menuBtn.setLocation(505, 473);
        menuBtn.setSize(120, 23);
        
        // QuitGame
        quitConfirmBtn.setLocation(10, 152);
        quitConfirmBtn.setSize(90, 23);
        quitDenyBtn.setLocation(120, 152);
        quitDenyBtn.setSize(90, 23);
        
        // NoEscape
        continueBtn.setSize(90, 23);
        
        // GameOver
        
        // AfterAction
        equipBtn.setLocation(505, 226);
        equipBtn.setSize(90, 23);
        ignoreBtn.setLocation(605, 226);
        ignoreBtn.setSize(90, 23);
                
    }

    private void configureActionListeners() {
		// TODO Auto-generated method stub
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
    			
	}

    private void generateGui() {
        frame = new JFrame();
        panel = new JPanel();

        frame.setTitle("Swingy - cdiogo");
        frame.setSize(720, 548);
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
        generateGui();
        controller.displayState();
    }

    @Override
    public void playGame() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        printMap();
        panel.add(mapText);
        
        messageText.setBounds(505, 11, 190, 88);
        messageText.setText(" Reach the edge of the map to win the current mission.\n\n Enemies may be encountered!");
        if (controller.isHeroEscaped()) {
            controller.setHeroEscaped(false);
            messageText.setText(" You have successfully escaped!");
        }
        if (controller.isLevelUp()) {
            controller.setLevelUp(false);
            messageText.setText(" You have levelled up!");
        }
        quitBtn.setLocation(635, 473);
        panel.add(messageText);
        panel.add(upBtn);
        panel.add(downBtn);
        panel.add(leftBtn);
        panel.add(rightBtn);
        panel.add(quitBtn);
        panel.add(saveBtn);
        
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
        
        line = String.format(" You have encountered a villain!\n\n %s", controller.getCurrentEnemy().toString());
        messageText.setText(line);
        messageText.setBounds(505, 11, 190, 88);
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
        
        messageText.setText(" You have Successfully completed this level!\r\n\r\n Continue your adventure from the main menu, or try a new character.");
        messageText.setBounds(505, 11, 190, 138);
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
        
        messageText.setText(" Are you sure you would like to quit the game?\r\n\r\n Confirm - Save and Quit\r\n Deny - Return to previous screen");
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
        
        messageText.setText(" Your attempt to flee has failed!\r\n\r\n Prepare for BATTLE!");
        messageText.setBounds(505, 11, 190, 88);
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
        
        messageText.setText("      GAME   OVER\r\n\r\n Your hero has died :(\r\n\r\n You may return to the menu and play again, or you may quit.");
        messageText.setBounds(505, 11, 190, 142);
        panel.add(messageText);
        quitBtn.setLocation(635, 473);
      
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
        
        messageText.setBounds(505, 11, 190, 170);
        panel.add(messageText);
        
        continueBtn.setLocation(505, 192);
        
        line += String.format(" You have defeated the %s\n", enemy.getName());
        line += String.format(" You gain %d XP\n", enemy.getXp());
        if (enemy.getArtifact() != null) {
            line += String.format("\n\n This villain dropped an artifact!\n %s", enemy.getArtifact().toString());
            line += "\n\n Would you like to equip it?";
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
}

package com.cdiogo.swingy.views;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.cdiogo.swingy.controllers.GameController;
import com.cdiogo.swingy.models.heroes.Player;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GuiDisplay implements Display {

    GameController controller;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
//    JTextArea output = new JTextArea("Hello poes", 500, 500); //??? for map display
    JButton backBtn = new JButton("Back");
    JButton saveBtn = new JButton("Save");
    JButton equipBtn = new JButton("Equip");
    JButton ignoreBtn = new JButton("Ignore");
    JButton menuBtn = new JButton("Return to Menu");
    JButton upBtn = new JButton("North");
    JButton downBtn = new JButton("South");
    JButton rightBtn = new JButton("East");
    JButton leftBtn = new JButton("West");
    JButton quitBtn = new JButton("Save & Quit");
    JButton quitConfirmBtn = new JButton("Confirm");
    JButton quitDenyBtn = new JButton("Deny");
    JButton fightBtn = new JButton("Fight");
    JButton fleaBtn = new JButton("Flea");
    JButton continueBtn = new JButton("Continue");
    JButton createBtn = new JButton("Create Character");
    JButton loadBtn = new JButton("Load Character");
//    JLabel welcome = new JLabel("Welcome to SWINGY");
    private final JTextPane welcomeText = new JTextPane();
    JTextField heroNameText;
    private final JTextPane heroStatsText = new JTextPane();

    public GuiDisplay(GameController controller) {
        this.controller = controller;
        
        frame.setTitle("Swingy - cdiogo");
        frame.setSize(720, 548);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
               
        configureActionListeners();
        
        // START SCREEN
        // welcomeText.setEditable(false);
        // welcomeText.setText("\r\n   WELCOME TO                                  \r\n         _____          _                   \r\n        /  ___|        (_)                  \r\n        \\ `--.__      ___ _ __   __ _ _   _ \r\n         `--. \\ \\ /\\ / / | '_ \\ / _` | | | |\r\n        /\\__/ /\\ V  V /| | | | | (_| | |_| |\r\n        \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |\r\n                                 __/ | __/ |\r\n                                |___/ |___/ \r\n\r\n\r\n");
        // welcomeText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        // welcomeText.setBounds(10, 11, 352, 193);
        // welcomeText.setBackground(Color.LIGHT_GRAY);
        
        // createBtn.setSize(135, 23);
        // createBtn.setLocation(10, 215);
        // loadBtn.setSize(110, 23);
        // loadBtn.setLocation(155, 215);
        // quitBtn.setSize(75, 23);
        // quitBtn.setLocation(287, 215);
        
        // panel.add(createBtn);
        // panel.add(loadBtn);
        // panel.add(quitBtn);
        // panel.add(welcomeText);
        // END START SCREEN
        
        // CREATE SCREEN CLASS
        // welcomeText.setBackground(Color.LIGHT_GRAY);
        // welcomeText.setEditable(false);
        // welcomeText.setText("\r\n   WELCOME TO                                  \r\n         _____          _                   \r\n        /  ___|        (_)                  \r\n        \\ `--.__      ___ _ __   __ _ _   _ \r\n         `--. \\ \\ /\\ / / | '_ \\ / _` | | | |\r\n        /\\__/ /\\ V  V /| | | | | (_| | |_| |\r\n        \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |\r\n                                 __/ | __/ |\r\n                                |___/ |___/ \r\n\r\n\r\n");
        // welcomeText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        // welcomeText.setBounds(10, 11, 352, 193);
        // panel.add(welcomeText);
        
        // JSpinner classSelect = new JSpinner();
        // classSelect.setModel(new SpinnerNumberModel(1, 1, 4, 1));
        // classSelect.setBounds(410, 215, 92, 23);
        // panel.add(classSelect);
        
        // backBtn.setBounds(20, 215, 60, 23);
        // panel.add(backBtn);
        
        // JButton submitBtn = new JButton("Submit");
        // submitBtn.setBounds(512, 215, 85, 23);
        // panel.add(submitBtn);
        
        // JTextArea characterCreateText = new JTextArea();
        // characterCreateText.setBackground(Color.LIGHT_GRAY);
        // characterCreateText.setText("\r\n\r\n   Choose a Hero Class\r\n\r\n      1 - Ranger\r\n      2 - Wizard\r\n      3 - Fighter\r\n      4 - Rogue");
        // characterCreateText.setFont(new Font("Monospaced", Font.PLAIN, 13));
        // characterCreateText.setEditable(false);
        // characterCreateText.setBounds(400, 11, 295, 193);
        // panel.add(characterCreateText);
        
        // END CREATE SCREEN CLASS
        
        // START CREATE SCREEN NAME
//        JButton submitBtn = new JButton("Submit");
//        submitBtn.setBounds(597, 215, 85, 23);
//        panel.add(submitBtn);
//        welcomeText.setBackground(Color.LIGHT_GRAY);
//        
//        welcomeText.setEditable(false);
//        welcomeText.setText("\r\n   WELCOME TO                                  \r\n         _____          _                   \r\n        /  ___|        (_)                  \r\n        \\ `--.__      ___ _ __   __ _ _   _ \r\n         `--. \\ \\ /\\ / / | '_ \\ / _` | | | |\r\n        /\\__/ /\\ V  V /| | | | | (_| | |_| |\r\n        \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |\r\n                                 __/ | __/ |\r\n                                |___/ |___/ \r\n\r\n\r\n");
//        welcomeText.setFont(new Font("Monospaced", Font.PLAIN, 11));
//        welcomeText.setBounds(10, 11, 352, 193);
//        panel.add(welcomeText);
//        
//        JTextArea characterCreateText = new JTextArea();
//        characterCreateText.setBackground(Color.LIGHT_GRAY);
//        characterCreateText.setText("\r\n\r\n   Enter a name for your Hero");
//        characterCreateText.setFont(new Font("Monospaced", Font.PLAIN, 13));
//        characterCreateText.setEditable(false);
//        characterCreateText.setBounds(400, 11, 295, 193);
//        panel.add(characterCreateText);
//        
//        heroNameText = new JTextField();
//        heroNameText.setFont(new Font("Monospaced", Font.PLAIN, 11));
//        heroNameText.setBounds(410, 216, 159, 20);
//        panel.add(heroNameText);
//        heroNameText.setColumns(10);
        
        // END CREATE SCREEN NAME
        
        // START LOAD CHAR SCREEN
//        JButton submitBtn = new JButton("Submit");
//        submitBtn.setBounds(597, 215, 85, 23);
//        panel.add(submitBtn);
//        welcomeText.setBackground(Color.LIGHT_GRAY);
//      
//        welcomeText.setEditable(false);
//        welcomeText.setText("\r\n   WELCOME TO                                  \r\n         _____          _                   \r\n        /  ___|        (_)                  \r\n        \\ `--.__      ___ _ __   __ _ _   _ \r\n         `--. \\ \\ /\\ / / | '_ \\ / _` | | | |\r\n        /\\__/ /\\ V  V /| | | | | (_| | |_| |\r\n        \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |\r\n                                 __/ | __/ |\r\n                                |___/ |___/ \r\n\r\n\r\n");
//        welcomeText.setFont(new Font("Monospaced", Font.PLAIN, 11));
//        welcomeText.setBounds(10, 11, 352, 193);
//        panel.add(welcomeText);
//      
//        JTextArea characterLoadText = new JTextArea();
//        characterLoadText.setWrapStyleWord(true);
//        characterLoadText.setBackground(Color.LIGHT_GRAY);
//        characterLoadText.setText("\r\n\r\n   Choose a Hero");
//        characterLoadText.setFont(new Font("Monospaced", Font.PLAIN, 13));
//        characterLoadText.setEditable(false);
//        characterLoadText.setBounds(400, 11, 295, 193);
//        panel.add(characterLoadText);
//        
//        JSpinner heroSelect = new JSpinner();
//        heroSelect.setModel(new SpinnerNumberModel(1, 1, 4, 1));
//        heroSelect.setBounds(410, 215, 92, 23);
//        panel.add(heroSelect);
//        
//        backBtn.setBounds(20, 215, 60, 23);
//        panel.add(backBtn);
        // END LOAD CHAR SCREEN
        
        // START PLAY SCREEN
//        JTextPane mapText = new JTextPane();
//        mapText.setEditable(false);
//        mapText.setBackground(Color.LIGHT_GRAY);
//        mapText.setBounds(10, 11, 485, 485);
//        panel.add(mapText);
//        
//        JTextArea messageText = new JTextArea();
//        messageText.setWrapStyleWord(true);
//        messageText.setLineWrap(true);
//        messageText.setText("Placeholder text that will hopefully word wrap because long messages might exist?!");
//        messageText.setEditable(false);
//        messageText.setBackground(Color.LIGHT_GRAY);
//        messageText.setBounds(505, 11, 190, 88);
//        panel.add(messageText);
//        upBtn.setSize(60, 23);
//        upBtn.setLocation(570, 256);
//        
//        panel.add(upBtn);
//        downBtn.setSize(60, 23);
//        downBtn.setLocation(570, 286);
//        panel.add(downBtn);
//        leftBtn.setLocation(505, 286);
//        leftBtn.setSize(60, 23);
//        panel.add(leftBtn);
//        rightBtn.setLocation(635, 286);
//        rightBtn.setSize(60, 23);
//        panel.add(rightBtn);
//        quitBtn.setLocation(635, 473);
//        quitBtn.setSize(60, 23);
//        panel.add(quitBtn);
//        saveBtn.setLocation(505, 473);
//        saveBtn.setSize(60, 23);
//        panel.add(saveBtn);
//        heroStatsText.setText("HeroStats Here");
//        heroStatsText.setFont(new Font("Monospaced", Font.PLAIN, 11));
//        heroStatsText.setEditable(false);
//        heroStatsText.setBackground(Color.LIGHT_GRAY);
//        heroStatsText.setBounds(505, 110, 190, 115);
//        
//        panel.add(heroStatsText);
        // END PLAY SCREEN
        
        // START FIGHT SCREEN
//        JTextPane mapText = new JTextPane();
//        mapText.setEditable(false);
//        mapText.setBackground(Color.LIGHT_GRAY);
//        mapText.setBounds(10, 11, 485, 485);
//        panel.add(mapText);
//        
//        JTextArea messageText = new JTextArea();
//        messageText.setWrapStyleWord(true);
//        messageText.setLineWrap(true);
//        messageText.setText("Placeholder text that will hopefully word wrap because long messages might exist?!");
//        messageText.setEditable(false);
//        messageText.setBackground(Color.LIGHT_GRAY);
//        messageText.setBounds(505, 11, 190, 88);
//        panel.add(messageText);
//        fightBtn.setLocation(505, 110);
//        fightBtn.setSize(60, 23);
//        panel.add(fightBtn);
//        fleaBtn.setLocation(505, 140);
//        fleaBtn.setSize(60, 23);
//        panel.add(fleaBtn);
        // END FIGHT SCREEN
        
        // START NO ESCAPE
//        JTextPane mapText = new JTextPane();
//        mapText.setEditable(false);
//        mapText.setBackground(Color.LIGHT_GRAY);
//        mapText.setBounds(10, 11, 485, 485);
//        panel.add(mapText);
//        
//        JTextArea messageText = new JTextArea();
//        messageText.setWrapStyleWord(true);
//        messageText.setLineWrap(true);
//        messageText.setText("Your attempt to flea has failed!\r\n\r\nPrepare for BATTLE!");
//        messageText.setEditable(false);
//        messageText.setBackground(Color.LIGHT_GRAY);
//        messageText.setBounds(505, 11, 190, 88);
//        panel.add(messageText);
//        continueBtn.setLocation(505, 110);
//        continueBtn.setSize(90, 23);
//        panel.add(continueBtn);
        // END NO ESCAPE
        
        // START ROUND WON
//        JTextPane mapText = new JTextPane();
//        mapText.setEditable(false);
//        mapText.setBackground(Color.LIGHT_GRAY);
//        mapText.setBounds(10, 11, 485, 485);
//        panel.add(mapText);
//        
//        JTextArea messageText = new JTextArea();
//        messageText.setWrapStyleWord(true);
//        messageText.setLineWrap(true);
//        messageText.setText("You have Successfully completed this level!\r\n\r\nContinue your adventure from the main menu, or try a new character.");
//        messageText.setEditable(false);
//        messageText.setBackground(Color.LIGHT_GRAY);
//        messageText.setBounds(505, 11, 190, 138);
//        panel.add(messageText);
//        quitBtn.setLocation(635, 473);
//        quitBtn.setSize(60, 23);
//        
//        panel.add(quitBtn);
//        menuBtn.setLocation(505, 473);
//        menuBtn.setSize(120, 23);
//        panel.add(menuBtn);
        // END ROUND WON
        
        // START GAME OVER
//        JTextPane mapText = new JTextPane();
//        mapText.setEditable(false);
//        mapText.setBackground(Color.LIGHT_GRAY);
//        mapText.setBounds(10, 11, 485, 485);
//        panel.add(mapText);
//        
//        JTextArea messageText = new JTextArea();
//        messageText.setWrapStyleWord(true);
//        messageText.setLineWrap(true);
//        messageText.setText("      GAME   OVER\r\n\r\nYour hero has died :(\r\n\r\nYou may return to the menu and play again, or you may quit.");
//        messageText.setEditable(false);
//        messageText.setBackground(Color.LIGHT_GRAY);
//        messageText.setBounds(505, 11, 190, 142);
//        panel.add(messageText);
//        quitBtn.setLocation(635, 473);
//        quitBtn.setSize(60, 23);
//      
//        panel.add(quitBtn);
//        menuBtn.setLocation(505, 473);
//        menuBtn.setSize(120, 23);
//        panel.add(menuBtn);
        // END GAME OVER
        
        // START AFTER ACTION
//        JTextPane mapText = new JTextPane();
//        mapText.setEditable(false);
//        mapText.setBackground(Color.LIGHT_GRAY);
//        mapText.setBounds(10, 11, 485, 485);
//        panel.add(mapText);
//        
//        JTextArea messageText = new JTextArea();
//        messageText.setWrapStyleWord(true);
//        messageText.setLineWrap(true);
//        messageText.setText("Placeholder Text");
//        messageText.setEditable(false);
//        messageText.setBackground(Color.LIGHT_GRAY);
//        messageText.setBounds(505, 11, 190, 154);
//        panel.add(messageText);
//        
//        continueBtn.setLocation(505, 176);
//        continueBtn.setSize(90, 23);
//        panel.add(continueBtn);
//        
//        equipBtn.setLocation(505, 210);
//        equipBtn.setSize(90, 23);
//        panel.add(equipBtn);
//        
//        ignoreBtn.setLocation(605, 210);
//        ignoreBtn.setSize(90, 23);
//        
//        panel.add(ignoreBtn);
        // END AFTER ACTION
        
        // START QUIT
//        JTextPane mapText = new JTextPane();
//        mapText.setEditable(false);
//        mapText.setBackground(Color.LIGHT_GRAY);
//        mapText.setBounds(10, 11, 485, 485);
//        panel.add(mapText);
//        
//        JTextArea messageText = new JTextArea();
//        messageText.setWrapStyleWord(true);
//        messageText.setLineWrap(true);
//        messageText.setText("Are you sure you would like to quit the game?");
//        messageText.setEditable(false);
//        messageText.setBackground(Color.LIGHT_GRAY);
//        messageText.setBounds(505, 11, 190, 72);
//        panel.add(messageText);
//        quitConfirmBtn.setLocation(540, 473);
//        quitConfirmBtn.setSize(120, 23);
//    
//        panel.add(quitConfirmBtn);
//        quitDenyBtn.setLocation(540, 439);
//        quitDenyBtn.setSize(120, 23);
//        panel.add(quitDenyBtn);
        // END QUIT
        
//         frame.setVisible(true);
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
    			
	}

	@Override
    public void startScreen() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        welcomeText.setBackground(Color.LIGHT_GRAY);
        welcomeText.setText("\r\n   WELCOME TO                                  \r\n         _____          _                   \r\n        /  ___|        (_)                  \r\n        \\ `--.__      ___ _ __   __ _ _   _ \r\n         `--. \\ \\ /\\ / / | '_ \\ / _` | | | |\r\n        /\\__/ /\\ V  V /| | | | | (_| | |_| |\r\n        \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |\r\n                                 __/ | __/ |\r\n                                |___/ |___/ \r\n\r\n\r\n");
        welcomeText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        welcomeText.setBounds(10, 11, 352, 193);
        createBtn.setSize(135, 23);
        createBtn.setLocation(10, 215);
        loadBtn.setSize(110, 23);
        loadBtn.setLocation(155, 215);
        quitBtn.setSize(75, 23);
        quitBtn.setLocation(287, 215);
        
        
        panel.add(createBtn);
        panel.add(loadBtn);
        panel.add(quitBtn);
        panel.add(welcomeText);
        
        
        panel.validate();
        panel.repaint();
        
        frame.setVisible(true);

    }

    @Override
    public String createCharName() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBounds(597, 215, 85, 23);
        panel.add(submitBtn);
        welcomeText.setBackground(Color.LIGHT_GRAY);
        
        welcomeText.setEditable(false);
        welcomeText.setText("\r\n   WELCOME TO                                  \r\n         _____          _                   \r\n        /  ___|        (_)                  \r\n        \\ `--.__      ___ _ __   __ _ _   _ \r\n         `--. \\ \\ /\\ / / | '_ \\ / _` | | | |\r\n        /\\__/ /\\ V  V /| | | | | (_| | |_| |\r\n        \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |\r\n                                 __/ | __/ |\r\n                                |___/ |___/ \r\n\r\n\r\n");
        welcomeText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        welcomeText.setBounds(10, 11, 352, 193);
        panel.add(welcomeText);
        
        JTextArea characterCreateText = new JTextArea();
        characterCreateText.setBackground(Color.LIGHT_GRAY);
        characterCreateText.setText("\r\n\r\n   Enter a name for your Hero");
        characterCreateText.setFont(new Font("Monospaced", Font.PLAIN, 13));
        characterCreateText.setEditable(false);
        characterCreateText.setBounds(400, 11, 295, 193);
        panel.add(characterCreateText);
        
        heroNameText = new JTextField();
        heroNameText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        heroNameText.setBounds(410, 216, 159, 20);
        panel.add(heroNameText);
        heroNameText.setColumns(10);
                
        return null;
    }

    @Override
    public void createCharClass() {
        // TODO Auto-generated method stub
        panel.removeAll();
        welcomeText.setEditable(false);
        welcomeText.setText("\r\n   WELCOME TO                                  \r\n         _____          _                   \r\n        /  ___|        (_)                  \r\n        \\ `--.__      ___ _ __   __ _ _   _ \r\n         `--. \\ \\ /\\ / / | '_ \\ / _` | | | |\r\n        /\\__/ /\\ V  V /| | | | | (_| | |_| |\r\n        \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |\r\n                                 __/ | __/ |\r\n                                |___/ |___/ \r\n\r\n\r\n");
        welcomeText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        welcomeText.setBounds(10, 11, 352, 193);
        panel.add(welcomeText);
        
        JSpinner classSelect = new JSpinner();
        classSelect.setModel(new SpinnerNumberModel(1, 1, 4, 1));
        classSelect.setBounds(410, 215, 92, 23);
        panel.add(classSelect);
        
        backBtn.setBounds(20, 215, 60, 23);
        panel.add(backBtn);
        
        
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBounds(512, 215, 85, 23);
        panel.add(submitBtn);
        
        JTextArea characterCreateText = new JTextArea();
        characterCreateText.setBackground(Color.LIGHT_GRAY);
        characterCreateText.setText("\r\n\r\n   Choose a Hero Class\r\n\r\n      1 - Ranger\r\n      2 - Wizard\r\n      3 - Fighter\r\n      4 - Rogue");
        characterCreateText.setFont(new Font("Monospaced", Font.PLAIN, 13));
        characterCreateText.setEditable(false);
        characterCreateText.setBounds(400, 11, 295, 193);
        panel.add(characterCreateText);

        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void loadChar(List<Player> heroes) {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBounds(597, 215, 85, 23);
        panel.add(submitBtn);
        welcomeText.setBackground(Color.LIGHT_GRAY);
      
        welcomeText.setEditable(false);
        welcomeText.setText("\r\n   WELCOME TO                                  \r\n         _____          _                   \r\n        /  ___|        (_)                  \r\n        \\ `--.__      ___ _ __   __ _ _   _ \r\n         `--. \\ \\ /\\ / / | '_ \\ / _` | | | |\r\n        /\\__/ /\\ V  V /| | | | | (_| | |_| |\r\n        \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |\r\n                                 __/ | __/ |\r\n                                |___/ |___/ \r\n\r\n\r\n");
        welcomeText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        welcomeText.setBounds(10, 11, 352, 193);
        panel.add(welcomeText);
      
        JTextArea characterLoadText = new JTextArea();
        characterLoadText.setWrapStyleWord(true);
        characterLoadText.setBackground(Color.LIGHT_GRAY);
        characterLoadText.setText("\r\n\r\n   Choose a Hero");
        characterLoadText.setFont(new Font("Monospaced", Font.PLAIN, 13));
        characterLoadText.setEditable(false);
        characterLoadText.setBounds(400, 11, 295, 193);
        panel.add(characterLoadText);
        
        JSpinner heroSelect = new JSpinner();
        heroSelect.setModel(new SpinnerNumberModel(1, 1, 4, 1));
        heroSelect.setBounds(410, 215, 92, 23);
        panel.add(heroSelect);
        
        backBtn.setBounds(20, 215, 60, 23);
        panel.add(backBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);

    }

    @Override
    public void renderGame() {
        // TODO Auto-generated method stub
    	// while (!controller.isGameOver()) {
        controller.displayState();
        // }
    }

    @Override
    public void playGame() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        JTextPane mapText = new JTextPane();
        mapText.setEditable(false);
        mapText.setBackground(Color.LIGHT_GRAY);
        mapText.setBounds(10, 11, 485, 485);
        panel.add(mapText);
        
        JTextArea messageText = new JTextArea();
        messageText.setWrapStyleWord(true);
        messageText.setLineWrap(true);
        messageText.setText("Placeholder text that will hopefully word wrap because long messages might exist?!");
        messageText.setEditable(false);
        messageText.setBackground(Color.LIGHT_GRAY);
        messageText.setBounds(505, 11, 190, 88);
        panel.add(messageText);
        upBtn.setSize(60, 23);
        upBtn.setLocation(570, 110);
        
        panel.add(upBtn);
        downBtn.setSize(60, 23);
        downBtn.setLocation(570, 140);
        panel.add(downBtn);
        leftBtn.setLocation(505, 140);
        leftBtn.setSize(60, 23);
        panel.add(leftBtn);
        rightBtn.setLocation(635, 140);
        rightBtn.setSize(60, 23);
        panel.add(rightBtn);
        quitBtn.setLocation(635, 473);
        quitBtn.setSize(60, 23);
        panel.add(quitBtn);
        saveBtn.setLocation(505, 473);
        saveBtn.setSize(60, 23);
        panel.add(saveBtn);
        
        heroStatsText.setText("HeroStats Here");
        heroStatsText.setFont(new Font("Monospaced", Font.PLAIN, 11));
        heroStatsText.setEditable(false);
        heroStatsText.setBackground(Color.LIGHT_GRAY);
        heroStatsText.setBounds(505, 110, 190, 115);
        panel.add(heroStatsText);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);

    }

    @Override
    public void fightOrFlight() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        JTextPane mapText = new JTextPane();
        mapText.setEditable(false);
        mapText.setBackground(Color.LIGHT_GRAY);
        mapText.setBounds(10, 11, 485, 485);
        panel.add(mapText);
        
        JTextArea messageText = new JTextArea();
        messageText.setWrapStyleWord(true);
        messageText.setLineWrap(true);
        messageText.setText("Placeholder text that will hopefully word wrap because long messages might exist?!");
        messageText.setEditable(false);
        messageText.setBackground(Color.LIGHT_GRAY);
        messageText.setBounds(505, 11, 190, 88);
        panel.add(messageText);
        fightBtn.setLocation(505, 110);
        fightBtn.setSize(60, 23);
        panel.add(fightBtn);
        fleaBtn.setLocation(505, 140);
        fleaBtn.setSize(60, 23);
        panel.add(fleaBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void roundWon() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        JTextPane mapText = new JTextPane();
        mapText.setEditable(false);
        mapText.setBackground(Color.LIGHT_GRAY);
        mapText.setBounds(10, 11, 485, 485);
        panel.add(mapText);
        
        JTextArea messageText = new JTextArea();
        messageText.setWrapStyleWord(true);
        messageText.setLineWrap(true);
        messageText.setText("You have Successfully completed this level!\r\n\r\nContinue your adventure from the main menu, or try a new character.");
        messageText.setEditable(false);
        messageText.setBackground(Color.LIGHT_GRAY);
        messageText.setBounds(505, 11, 190, 138);
        panel.add(messageText);
        quitBtn.setLocation(635, 473);
        quitBtn.setSize(60, 23);
        
        panel.add(quitBtn);
        menuBtn.setLocation(505, 473);
        menuBtn.setSize(120, 23);
        panel.add(menuBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);

    }

    @Override
    public void quitGame() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        JTextPane mapText = new JTextPane();
        mapText.setEditable(false);
        mapText.setBackground(Color.LIGHT_GRAY);
        mapText.setBounds(10, 11, 485, 485);
        panel.add(mapText);
        
        JTextArea messageText = new JTextArea();
        messageText.setWrapStyleWord(true);
        messageText.setLineWrap(true);
        messageText.setText("Are you sure you would like to quit the game?");
        messageText.setEditable(false);
        messageText.setBackground(Color.LIGHT_GRAY);
        messageText.setBounds(505, 11, 190, 72);
        panel.add(messageText);
        quitConfirmBtn.setLocation(540, 473);
        quitConfirmBtn.setSize(120, 23);
    
        panel.add(quitConfirmBtn);
        quitDenyBtn.setLocation(540, 439);
        quitDenyBtn.setSize(120, 23);
        panel.add(quitDenyBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);

    }

    @Override
    public void noEscape() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        JTextPane mapText = new JTextPane();
        mapText.setEditable(false);
        mapText.setBackground(Color.LIGHT_GRAY);
        mapText.setBounds(10, 11, 485, 485);
        panel.add(mapText);
        
        JTextArea messageText = new JTextArea();
        messageText.setWrapStyleWord(true);
        messageText.setLineWrap(true);
        messageText.setText("Your attempt to flea has failed!\r\n\r\nPrepare for BATTLE!");
        messageText.setEditable(false);
        messageText.setBackground(Color.LIGHT_GRAY);
        messageText.setBounds(505, 11, 190, 88);
        panel.add(messageText);
        continueBtn.setLocation(505, 110);
        continueBtn.setSize(90, 23);
        panel.add(continueBtn);
                
        panel.validate();
        panel.repaint();
        frame.setVisible(true);

    }

    @Override
    public void gameOver() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        JTextPane mapText = new JTextPane();
        mapText.setEditable(false);
        mapText.setBackground(Color.LIGHT_GRAY);
        mapText.setBounds(10, 11, 485, 485);
        panel.add(mapText);
        
        JTextArea messageText = new JTextArea();
        messageText.setWrapStyleWord(true);
        messageText.setLineWrap(true);
        messageText.setText("      GAME   OVER\r\n\r\nYour hero has died :(\r\n\r\nYou may return to the menu and play again, or you may quit.");
        messageText.setEditable(false);
        messageText.setBackground(Color.LIGHT_GRAY);
        messageText.setBounds(505, 11, 190, 142);
        panel.add(messageText);
        quitBtn.setLocation(635, 473);
        quitBtn.setSize(60, 23);
      
        panel.add(quitBtn);
        menuBtn.setLocation(505, 473);
        menuBtn.setSize(120, 23);
        panel.add(menuBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);

    }

    @Override
    public void afterAction() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        JTextPane mapText = new JTextPane();
        mapText.setEditable(false);
        mapText.setBackground(Color.LIGHT_GRAY);
        mapText.setBounds(10, 11, 485, 485);
        panel.add(mapText);
        
        JTextArea messageText = new JTextArea();
        messageText.setWrapStyleWord(true);
        messageText.setLineWrap(true);
        messageText.setText("Placeholder Text");
        messageText.setEditable(false);
        messageText.setBackground(Color.LIGHT_GRAY);
        messageText.setBounds(505, 11, 190, 154);
        panel.add(messageText);
        
        continueBtn.setLocation(505, 176);
        continueBtn.setSize(90, 23);
        panel.add(continueBtn);
        
        equipBtn.setLocation(505, 210);
        equipBtn.setSize(90, 23);
        panel.add(equipBtn);
        
        ignoreBtn.setLocation(605, 210);
        ignoreBtn.setSize(90, 23);
        
        panel.add(ignoreBtn);
        
        panel.validate();
        panel.repaint();
        frame.setVisible(true);

    }
}

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

public class GuiDisplay implements Display {

    GameController controller;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextArea output = new JTextArea("Hello poes", 500, 500); //??? for map display
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
    JButton createBtn = new JButton("Create Character");
    JButton loadBtn = new JButton("Load Character");
//    JLabel welcome = new JLabel("Welcome to SWINGY");
    private final JTextPane welcomeText = new JTextPane();

    public GuiDisplay(GameController controller) {
        this.controller = controller;
        frame.setTitle("Swingy - cdiogo");
        frame.setSize(720, 548);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        // START SCREEN
        welcomeText.setEditable(false);
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
        // END START SCREEN
        
        // CREATE SCREEN
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
        // characterCreateText.setText("\r\n\r\n   Choose a Hero Class\r\n\r\n      1 - Ranger\r\n      2 - Wizard\r\n      3 - Fighter\r\n      4 - Rogue");
        // characterCreateText.setFont(new Font("Monospaced", Font.PLAIN, 13));
        // characterCreateText.setEditable(false);
        // characterCreateText.setBounds(400, 11, 295, 193);
        // panel.add(characterCreateText);
        
        // END CREATE SCREEN
        
        frame.setVisible(true);
    }

    @Override
    public void startScreen() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
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
        
        createBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		controller.handleInput("c");
        	}
        });
        
        panel.repaint();
        frame.setVisible(true);

    }

    @Override
    public String createCharName() {
        // TODO Auto-generated method stub
        panel.removeAll();
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
        
        backBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		controller.handleInput("b");
        	}
        });
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBounds(512, 215, 85, 23);
        panel.add(submitBtn);
        
        JTextArea characterCreateText = new JTextArea();
        characterCreateText.setText("\r\n\r\n   Choose a Hero Class\r\n\r\n      1 - Ranger\r\n      2 - Wizard\r\n      3 - Fighter\r\n      4 - Rogue");
        characterCreateText.setFont(new Font("Monospaced", Font.PLAIN, 13));
        characterCreateText.setEditable(false);
        characterCreateText.setBounds(400, 11, 295, 193);
        panel.add(characterCreateText);

        panel.repaint();
        frame.setVisible(true);
    }

    @Override
    public void loadChar(List<Player> heroes) {
        // TODO Auto-generated method stub
        panel.removeAll();

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

    }

    @Override
    public void fightOrFlight() {
        // TODO Auto-generated method stub
        panel.removeAll();
    }

    @Override
    public void roundWon() {
        // TODO Auto-generated method stub
        panel.removeAll();

    }

    @Override
    public void quitGame() {
        // TODO Auto-generated method stub
        panel.removeAll();

    }

    @Override
    public void noEscape() {
        // TODO Auto-generated method stub
        panel.removeAll();

    }

    @Override
    public void gameOver() {
        // TODO Auto-generated method stub
        panel.removeAll();

    }

    @Override
    public void afterAction() {
        // TODO Auto-generated method stub
        panel.removeAll();

    }
}

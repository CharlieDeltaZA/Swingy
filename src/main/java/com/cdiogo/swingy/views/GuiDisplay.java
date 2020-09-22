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

public class GuiDisplay implements Display {

    GameController controller;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextArea output = new JTextArea("Hello poes", 500, 500); //??? for map display
    JButton back = new JButton("Back");
    JButton save = new JButton("Save");
    JButton equip = new JButton("Equip");
    JButton ignore = new JButton("Ignore");
    JButton menu = new JButton("Return to Menu");
    JButton up = new JButton("North");
    JButton down = new JButton("South");
    JButton right = new JButton("East");
    JButton left = new JButton("West");
    JButton quit = new JButton("Quit");
    JButton create = new JButton("Create Character");
    JButton load = new JButton("Load Character");
//    JLabel welcome = new JLabel("Welcome to SWINGY");
    private final JTextPane welcome = new JTextPane();

    public GuiDisplay(GameController controller) {
        this.controller = controller;
        frame.setTitle("Swingy - cdiogo");
        frame.setSize(780, 548);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
//        welcome.setBounds(288, 331, 99, 14);
//        panel.add(welcome);
        back.setBounds(277, 475, 55, 23);
        panel.add(back);
        
        
        // panel.add(output);
        frame.setVisible(true);
    }

    @Override
    public void startScreen() {
        // TODO Auto-generated method stub
        panel.removeAll();
        
        welcome.setText("\r\n   WELCOME TO                                  \r\n         _____          _                   \r\n        /  ___|        (_)                  \r\n        \\ `--.__      ___ _ __   __ _ _   _ \r\n         `--. \\ \\ /\\ / / | '_ \\ / _` | | | |\r\n        /\\__/ /\\ V  V /| | | | | (_| | |_| |\r\n        \\____/  \\_/\\_/ |_|_| |_|\\__, |\\__, |\r\n                                 __/ | __/ |\r\n                                |___/ |___/ \r\n\r\n\r\n");
        welcome.setFont(new Font("Monospaced", Font.PLAIN, 11));
        welcome.setBounds(10, 11, 352, 193);
        create.setSize(120, 23);
        create.setLocation(10, 215);
        load.setSize(120, 23);
        load.setLocation(140, 215);
        quit.setSize(75, 23);
        quit.setLocation(287, 215);
        
        panel.add(create);
        panel.add(load);
        panel.add(quit);
        panel.add(welcome);
        
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

    }

    @Override
    public void loadChar(List<Player> heroes) {
        // TODO Auto-generated method stub
        panel.removeAll();

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

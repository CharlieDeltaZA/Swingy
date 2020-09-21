package com.cdiogo.swingy.views;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.cdiogo.swingy.controllers.GameController;
import com.cdiogo.swingy.models.heroes.Player;

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
    JLabel welcome = new JLabel("Welcome to SWINGY");

    public GuiDisplay(GameController controller) {
        this.controller = controller;
        frame.setTitle("Swingy - cdiogo");
        frame.setSize(860, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.add(welcome);
        back.setBounds(20, 20, 50, 20);
        panel.add(back);
        // panel.add(output);
        frame.setVisible(true);
    }

    @Override
    public void startScreen() {
        // TODO Auto-generated method stub
        panel.removeAll();
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
        panel.removeAll();

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

package com.cdiogo.swingy.views;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.cdiogo.swingy.controllers.GameController;
import com.cdiogo.swingy.models.heroes.Player;

public class GuiDisplay implements Display {

    GameController controller;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton test = new JButton("Test");
    JTextArea output = new JTextArea("Hello\n\n\n\n poes");

    public GuiDisplay(GameController controller) {
        this.controller = controller;
        frame.setTitle("Swingy - cdiogo");
        frame.setSize(640, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.add(test);
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

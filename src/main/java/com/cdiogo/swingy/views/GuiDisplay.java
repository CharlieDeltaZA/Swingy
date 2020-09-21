package com.cdiogo.swingy.views;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.cdiogo.swingy.controllers.GameController;
import com.cdiogo.swingy.models.heroes.Player;

public class GuiDisplay implements Display {

    GameController controller;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    public GuiDisplay(GameController controller) {
        this.controller = controller;
        frame.setTitle("Swingy - cdiogo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void startScreen() {
        // TODO Auto-generated method stub
        panel.removeAll();

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

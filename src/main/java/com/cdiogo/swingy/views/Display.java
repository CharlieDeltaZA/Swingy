package com.cdiogo.swingy.views;

import java.util.List;

import com.cdiogo.swingy.models.heroes.Player;

public interface Display {
    public void startScreen();
	public String createCharName();
    public void createCharClass();
	public void loadChar(List<Player> heroes);
    public void renderGame();
    public void playGame();
    public void fightOrFlight();
}
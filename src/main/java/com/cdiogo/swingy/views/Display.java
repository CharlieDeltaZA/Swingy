package com.cdiogo.swingy.views;

import java.util.List;

import com.cdiogo.swingy.models.heroes.Player;

public interface Display {
    public void startScreen();
	public void createCharName();
    public void createCharClass();
	public void loadChar(List<Player> heroes);
    public void renderGame();
    public void playGame();
    public void fightOrFlight();
	public void roundWon();
	public void quitGame();
	public void noEscape();
	public void gameOver();
	public void afterAction();
}

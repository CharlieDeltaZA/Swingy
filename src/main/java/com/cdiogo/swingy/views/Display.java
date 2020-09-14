package com.cdiogo.swingy.views;

import java.util.List;

import com.cdiogo.swingy.models.heroes.Player;

public interface Display {
    public void startScreen();
	public String createCharName();
    public String createCharClass();
	public String loadChar(List<Player> heroes);
    public void renderGame();
}

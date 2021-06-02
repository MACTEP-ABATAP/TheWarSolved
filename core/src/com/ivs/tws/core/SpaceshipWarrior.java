package com.ivs.tws.core;

import com.badlogic.gdx.Game;
import com.ivs.tws.core.GameScreen;

public class SpaceshipWarrior extends Game {

	private GameScreen gameScreen;

	@Override
	public void create() {
		this.gameScreen = new GameScreen();
		setScreen(gameScreen);
	}

}

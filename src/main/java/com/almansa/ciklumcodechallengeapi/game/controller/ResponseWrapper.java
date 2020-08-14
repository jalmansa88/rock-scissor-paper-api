package com.almansa.ciklumcodechallengeapi.game.controller;

import com.almansa.ciklumcodechallengeapi.game.domain.Game;

public class ResponseWrapper {
	private Game game;
	
	public ResponseWrapper(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
}

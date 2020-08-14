package com.almansa.ciklumcodechallengeapi.player.domain;

public enum RoundWinner {
	DRAW("Draw"), PLAYER_ONE("Player One"), PLAYER_TWO("Player Two");
	
	private String name;

	RoundWinner(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

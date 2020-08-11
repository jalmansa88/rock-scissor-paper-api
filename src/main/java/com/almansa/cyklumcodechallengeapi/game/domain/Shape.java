package com.almansa.cyklumcodechallengeapi.game.domain;

public enum Shape {
	ROCK("Rock"), PAPER("Paper"), SCISSORS("Scissors");

	private String name;

	Shape(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

package com.almansa.ciklumcodechallengeapi.player.domain;

import com.almansa.ciklumcodechallengeapi.game.domain.Shape;
import com.almansa.ciklumcodechallengeapi.player.strategy.PlayerStrategy;

public class Player {

	private PlayerStrategy playerStrategy;

	public Player(PlayerStrategy playerStrategy) {
		this.playerStrategy = playerStrategy;
	}

	public Shape showHand() {
		return playerStrategy.makeDecision();
	}
}

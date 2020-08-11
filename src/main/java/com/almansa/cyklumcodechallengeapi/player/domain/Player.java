package com.almansa.cyklumcodechallengeapi.player.domain;

import com.almansa.cyklumcodechallengeapi.game.domain.Shape;
import com.almansa.cyklumcodechallengeapi.player.strategy.PlayerStrategy;

public class Player {

	private PlayerStrategy playerStrategy;

	public Player(PlayerStrategy playerStrategy) {
		this.playerStrategy = playerStrategy;
	}

	public Shape showHand() {
		return playerStrategy.makeDecision();
	}
}

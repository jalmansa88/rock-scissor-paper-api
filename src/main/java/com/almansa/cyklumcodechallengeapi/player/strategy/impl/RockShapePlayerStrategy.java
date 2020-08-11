package com.almansa.cyklumcodechallengeapi.player.strategy.impl;

import com.almansa.cyklumcodechallengeapi.game.domain.Shape;
import com.almansa.cyklumcodechallengeapi.player.strategy.PlayerStrategy;

public class RockShapePlayerStrategy implements PlayerStrategy{

	@Override
	public Shape makeDecision() {
		return Shape.ROCK;
	}

}

package com.almansa.ciklumcodechallengeapi.player.strategy.impl;

import com.almansa.ciklumcodechallengeapi.game.domain.Shape;
import com.almansa.ciklumcodechallengeapi.player.strategy.PlayerStrategy;

public class RockShapePlayerStrategy implements PlayerStrategy{

	@Override
	public Shape makeDecision() {
		return Shape.ROCK;
	}

}

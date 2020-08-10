package com.almansa.cyklumcodechallengeapi.player.strategy.impl;

import com.almansa.cyklumcodechallengeapi.player.strategy.PlayerStrategy;
import com.almansa.cyklumcodechallengeapi.shape.Shape;

public class RockPlayerStrategy implements PlayerStrategy{

	@Override
	public Shape playHand() {
		return Shape.ROCK;
	}

}

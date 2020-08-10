package com.almansa.cyklumcodechallengeapi.player.strategy.impl;

import java.util.Random;

import com.almansa.cyklumcodechallengeapi.player.strategy.PlayerStrategy;
import com.almansa.cyklumcodechallengeapi.shape.Shape;

public class RandomShapePlayerStrategy implements PlayerStrategy {
	public Shape playHand() {
		Random random = new Random();
		return Shape.values()[random.nextInt(Shape.values().length)];
	}
}

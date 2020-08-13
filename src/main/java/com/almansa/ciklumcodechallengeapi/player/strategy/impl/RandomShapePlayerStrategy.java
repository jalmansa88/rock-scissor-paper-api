package com.almansa.ciklumcodechallengeapi.player.strategy.impl;

import java.util.Random;

import com.almansa.ciklumcodechallengeapi.game.domain.Shape;
import com.almansa.ciklumcodechallengeapi.player.strategy.PlayerStrategy;

public class RandomShapePlayerStrategy implements PlayerStrategy {
	public Shape makeDecision() {
		Random random = new Random();
		return Shape.values()[random.nextInt(Shape.values().length)];
	}
}

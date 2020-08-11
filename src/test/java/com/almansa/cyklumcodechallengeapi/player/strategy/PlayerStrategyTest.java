package com.almansa.cyklumcodechallengeapi.player.strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.almansa.cyklumcodechallengeapi.game.domain.Shape;
import com.almansa.cyklumcodechallengeapi.player.strategy.PlayerStrategy;
import com.almansa.cyklumcodechallengeapi.player.strategy.impl.RandomShapePlayerStrategy;
import com.almansa.cyklumcodechallengeapi.player.strategy.impl.RockShapePlayerStrategy;

public class PlayerStrategyTest {

	@Test
	public void shouldReturnAlwaysRockShape() {
		PlayerStrategy playerStrategy = new RockShapePlayerStrategy();
		Shape shape = playerStrategy.playHand();
		assertEquals(Shape.ROCK, shape);
	}

	@Test
	public void shouldReturnRandomShape() {
		PlayerStrategy playerStrategy = new RandomShapePlayerStrategy();
		Shape shape = playerStrategy.playHand();
		assertThat(shape).isIn(Shape.ROCK, Shape.PAPER, Shape.SCISSORS);
	}
}

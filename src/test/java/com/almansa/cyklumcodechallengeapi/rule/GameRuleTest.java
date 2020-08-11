package com.almansa.cyklumcodechallengeapi.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.almansa.cyklumcodechallengeapi.game.domain.Shape;
import com.almansa.cyklumcodechallengeapi.rule.impl.GameRuleServiceImpl;

public class GameRuleTest {

	@Test
	public void shouldResultDraw() {
		GameRuleService gameRule = new GameRuleServiceImpl();
		
		int result = gameRule.getWinner(Shape.PAPER, Shape.PAPER);
		
		assertEquals(0, result);
	}
	@Test
	public void rockShouldWinScissors() {
		GameRuleService gameRule = new GameRuleServiceImpl();
		
		int result = gameRule.getWinner(Shape.ROCK, Shape.SCISSORS);
		
		assertEquals(1, result);
	}
	@Test
	public void paperShouldWinRock() {
		GameRuleService gameRule = new GameRuleServiceImpl();
		
		int result = gameRule.getWinner(Shape.PAPER, Shape.ROCK);
		
		assertEquals(1, result);
	}
	@Test
	public void scissorsShouldWinPaper() {
		GameRuleService gameRule = new GameRuleServiceImpl();
		
		int result = gameRule.getWinner(Shape.SCISSORS, Shape.PAPER);
		
		assertEquals(1, result);
	}
}

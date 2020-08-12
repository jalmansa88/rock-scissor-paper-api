package com.almansa.cyklumcodechallengeapi.game.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.almansa.cyklumcodechallengeapi.game.domain.Shape;
import com.almansa.cyklumcodechallengeapi.game.rule.impl.GameRuleImpl;
import com.almansa.cyklumcodechallengeapi.player.domain.RoundWinner;

public class GameRuleTest {

	@Test
	public void shouldResultDraw() {
		GameRule gameRule = new GameRuleImpl();
		
		RoundWinner result = gameRule.getWinner(Shape.PAPER, Shape.PAPER);
		
		assertEquals(RoundWinner.DRAW, result);
	}
	@Test
	public void rockShouldWinScissors() {
		GameRule gameRule = new GameRuleImpl();
		
		RoundWinner result = gameRule.getWinner(Shape.ROCK, Shape.SCISSORS);
		
		assertEquals(RoundWinner.PLAYER_ONE, result);
	}
	@Test
	public void paperShouldWinRock() {
		GameRule gameRule = new GameRuleImpl();
		
		RoundWinner result = gameRule.getWinner(Shape.PAPER, Shape.ROCK);
		
		assertEquals(RoundWinner.PLAYER_ONE, result);
	}
	@Test
	public void scissorsShouldWinPaper() {
		GameRule gameRule = new GameRuleImpl();
		
		RoundWinner result = gameRule.getWinner(Shape.SCISSORS, Shape.PAPER);
		
		assertEquals(RoundWinner.PLAYER_ONE, result);
	}
}

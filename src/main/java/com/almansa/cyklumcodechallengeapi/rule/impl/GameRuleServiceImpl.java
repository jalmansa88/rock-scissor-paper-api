package com.almansa.cyklumcodechallengeapi.rule.impl;

import org.springframework.stereotype.Component;

import com.almansa.cyklumcodechallengeapi.game.domain.Shape;
import com.almansa.cyklumcodechallengeapi.rule.GameRuleService;

@Component
public class GameRuleServiceImpl implements GameRuleService {

	private static final int DRAW = 0;
	private static final int PLAYER_1_WIN = 1;
	private static final int PLAYER_2_WIN = 2;

	@Override
	public int getWinner(Shape player1, Shape player2) {
		if (player1 == player2) {
			return DRAW;
		}

		if ((player1 == Shape.PAPER && player2 == Shape.ROCK) 
				|| (player1 == Shape.ROCK && player2 == Shape.SCISSORS)
				|| (player1 == Shape.SCISSORS && player2 == Shape.PAPER)) {
			return PLAYER_1_WIN;
		}

		return PLAYER_2_WIN;
	}

}

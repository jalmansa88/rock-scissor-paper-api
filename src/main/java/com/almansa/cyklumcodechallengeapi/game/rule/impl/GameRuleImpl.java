package com.almansa.cyklumcodechallengeapi.game.rule.impl;

import static com.almansa.cyklumcodechallengeapi.game.domain.Shape.PAPER;
import static com.almansa.cyklumcodechallengeapi.game.domain.Shape.ROCK;
import static com.almansa.cyklumcodechallengeapi.game.domain.Shape.SCISSORS;
import static com.almansa.cyklumcodechallengeapi.player.domain.RoundWinner.DRAW;
import static com.almansa.cyklumcodechallengeapi.player.domain.RoundWinner.PLAYER_ONE;
import static com.almansa.cyklumcodechallengeapi.player.domain.RoundWinner.PLAYER_TWO;

import org.springframework.stereotype.Component;

import com.almansa.cyklumcodechallengeapi.game.domain.Shape;
import com.almansa.cyklumcodechallengeapi.game.rule.GameRule;
import com.almansa.cyklumcodechallengeapi.player.domain.RoundWinner;

@Component
public class GameRuleImpl implements GameRule {

	@Override
	public RoundWinner getWinner(Shape player1, Shape player2) {
		if (player1 == player2) {
			return DRAW;
		}

		if ((player1 == PAPER && player2 == ROCK) 
				|| (player1 == ROCK && player2 == SCISSORS)
				|| (player1 == SCISSORS && player2 == PAPER)) {
			return PLAYER_ONE;
		}

		return PLAYER_TWO;
	}

}

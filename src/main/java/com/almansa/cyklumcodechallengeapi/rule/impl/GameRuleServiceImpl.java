package com.almansa.cyklumcodechallengeapi.rule.impl;

import org.springframework.stereotype.Component;

import com.almansa.cyklumcodechallengeapi.game.domain.Shape;
import com.almansa.cyklumcodechallengeapi.rule.GameRuleService;

@Component
public class GameRuleServiceImpl implements GameRuleService {

	@Override
	public int getWinner(Shape player1, Shape player2) {
		
		if (player1 == player2) {
			return 0;
		}
		
		if (player1 == Shape.PAPER && player2 == Shape.ROCK) {
			return 1;
		}
		
		if (player1 == Shape.ROCK) {
			
		}
		
		if (player1 == Shape.SCISSORS) {
			
		}
		return 0;
	}

}

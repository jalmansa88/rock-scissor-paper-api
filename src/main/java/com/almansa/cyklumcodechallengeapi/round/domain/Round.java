package com.almansa.cyklumcodechallengeapi.round.domain;

import com.almansa.cyklumcodechallengeapi.game.domain.Shape;
import com.almansa.cyklumcodechallengeapi.rule.GameRuleService;

public class Round {
	private Shape player1Selection;
	private Shape player2Selection;

	public Round(Shape player1Selection, Shape player2Selection) {
		this.player1Selection = player1Selection;
		this.player2Selection = player2Selection;
	}

	public int getWinner(GameRuleService rule) {
		return rule.getWinner(player1Selection, player2Selection);
	}
}

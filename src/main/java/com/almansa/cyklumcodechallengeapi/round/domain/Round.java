package com.almansa.cyklumcodechallengeapi.round.domain;

import com.almansa.cyklumcodechallengeapi.game.domain.Shape;
import com.almansa.cyklumcodechallengeapi.rule.GameRuleService;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Round {
	private Shape player1Selection;
	private Shape player2Selection;
	private int winner;

	public Round(Shape player1Selection, Shape player2Selection, GameRuleService rule) {
		this.player1Selection = player1Selection;
		this.player2Selection = player2Selection;
		this.winner = rule.getWinner(player1Selection, player2Selection);
	}

	@JsonProperty("WINNER")
	public int getWinner() {
		return winner;
	}

	@JsonProperty("P1_HAND")
	public String getPlayer1Selection() {
		return player1Selection.getName();
	}

	@JsonProperty("P2_HAND")
	public String getPlayer2Selection() {
		return player2Selection.getName();
	}
}

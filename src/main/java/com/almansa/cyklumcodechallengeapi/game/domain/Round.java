package com.almansa.cyklumcodechallengeapi.game.domain;

import com.almansa.cyklumcodechallengeapi.game.rule.GameRule;
import com.almansa.cyklumcodechallengeapi.player.domain.RoundWinner;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Round {
	private Shape player1Selection;
	private Shape player2Selection;
	private RoundWinner winner;

	public Round(Shape player1Selection, Shape player2Selection, GameRule rule) {
		this.player1Selection = player1Selection;
		this.player2Selection = player2Selection;
		this.winner = rule.getWinner(player1Selection, player2Selection);
	}

	@JsonProperty("WINNER")
	public RoundWinner getWinner() {
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

package com.almansa.ciklumcodechallengeapi.gamehistory.domain;

import java.util.Collection;

import com.almansa.ciklumcodechallengeapi.game.domain.Round;
import com.almansa.ciklumcodechallengeapi.player.domain.RoundWinner;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GameHistory {
	private Collection<Round> rounds;

	public GameHistory(Collection<Round> rounds) {
		this.rounds = rounds;
	}

	@JsonProperty("TOTAL_ROUNDS")
	public int getNumTotalRounds() {
		return rounds.size();
	}

	@JsonProperty("NUM_DRAWS")
	public int getNumDraws() {
		return getNumOfRoundsResultsByWinnerCode(RoundWinner.DRAW);
	}

	@JsonProperty("PLAYER_ONE_WINS")
	public int getNumWinsPlayerOne() {
		return getNumOfRoundsResultsByWinnerCode(RoundWinner.PLAYER_ONE);
	}

	@JsonProperty("PLAYER_TWO_WINS")
	public int getNumWinsPlayerTwo() {
		return getNumOfRoundsResultsByWinnerCode(RoundWinner.PLAYER_TWO);
	}

	private int getNumOfRoundsResultsByWinnerCode(RoundWinner winner) {
		return rounds.stream()
				.filter(round -> round.getWinner().equals(winner.getName()))
				.mapToInt(r -> 1)
				.sum();
	}
}

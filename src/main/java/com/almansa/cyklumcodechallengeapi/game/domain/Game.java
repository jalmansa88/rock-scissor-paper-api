package com.almansa.cyklumcodechallengeapi.game.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.almansa.cyklumcodechallengeapi.player.domain.Player;
import com.almansa.cyklumcodechallengeapi.round.domain.Round;
import com.almansa.cyklumcodechallengeapi.rule.GameRuleService;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Game {

	private Collection<Round> rounds;

	@JsonIgnore
	private GameRuleService gameRules;
	@JsonIgnore
	private Player player1;
	@JsonIgnore
	private Player player2;

	public Game(Player player1, Player player2, GameRuleService gameRules) {
		rounds = new ArrayList<>();
		this.player1 = player1;
		this.player2 = player2;
		this.gameRules = gameRules;
	}

	public Round playRound() {
		Round newPlayedRound = new Round(player1.showHand(), player2.showHand(), gameRules);
		rounds.add(newPlayedRound);
		return newPlayedRound;
	}

	public Collection<Round> getRounds() {
		return rounds;
	}
}

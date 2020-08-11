package com.almansa.cyklumcodechallengeapi.game.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.almansa.cyklumcodechallengeapi.player.domain.Player;
import com.almansa.cyklumcodechallengeapi.round.domain.Round;

public class Game {
	private Collection<Round> rounds;
	private Player player1;
	private Player player2;
	
	public Game(Player player1, Player player2) {
		rounds = new ArrayList<>();
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public Round playRound() {
		Round newPlayedRound = new Round(player1.getSelection(), player2.getSelection());
		rounds.add(newPlayedRound);
		return newPlayedRound;
	}
}

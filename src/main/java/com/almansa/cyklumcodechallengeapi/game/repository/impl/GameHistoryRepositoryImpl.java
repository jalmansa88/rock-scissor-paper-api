package com.almansa.cyklumcodechallengeapi.game.repository.impl;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.almansa.cyklumcodechallengeapi.game.repository.GameHistoryRepository;
import com.almansa.cyklumcodechallengeapi.round.domain.Round;

@Component
public class GameHistoryRepositoryImpl implements GameHistoryRepository{
	private Collection<Round> rounds;
	
	public int getNumTotalRounds() {
		return 0;
	}
	
	public int getNumFirstPlayerWins() {
		return 0;
	}
	
	public int getNumSecondPlayerWins() {
		return 0;
	}
	
	public int getNumDraws() {
		return 0;
	}
}

package com.almansa.cyklumcodechallengeapi.gamehistory.repository.impl;

import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Component;

import com.almansa.cyklumcodechallengeapi.gamehistory.domain.GameHistory;
import com.almansa.cyklumcodechallengeapi.gamehistory.repository.GameHistoryRepository;
import com.almansa.cyklumcodechallengeapi.round.domain.Round;

@Component
public class GameHistoryRepositoryImpl implements GameHistoryRepository {

	private Collection<Round> rounds = Collections.emptyList();

	@Override
	public void persistRound(Round round) {
		rounds.add(round);
	}

	@Override
	public GameHistory getHistory() {
		return null;
	}

	public int getNumTotalRounds() {
		return rounds.size();
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

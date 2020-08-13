package com.almansa.ciklumcodechallengeapi.gamehistory.repository.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.almansa.ciklumcodechallengeapi.game.domain.Round;
import com.almansa.ciklumcodechallengeapi.gamehistory.repository.GameHistoryRepository;

@Component
public class GameHistoryRepositoryImpl implements GameHistoryRepository {

	private Collection<Round> rounds;

	public GameHistoryRepositoryImpl() {
		rounds = new ArrayList<Round>();
	}

	@Override
	public void persistRound(Round round) {
		rounds.add(round);
	}

	@Override
	public Collection<Round> getRounds() {
		return rounds;
	}
}

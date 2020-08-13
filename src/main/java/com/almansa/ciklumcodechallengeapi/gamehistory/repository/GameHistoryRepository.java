package com.almansa.ciklumcodechallengeapi.gamehistory.repository;

import java.util.Collection;

import com.almansa.ciklumcodechallengeapi.game.domain.Round;

public interface GameHistoryRepository {
	public void persistRound(Round round);
	public Collection<Round> getRounds();
}

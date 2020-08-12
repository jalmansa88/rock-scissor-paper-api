package com.almansa.cyklumcodechallengeapi.gamehistory.repository;

import java.util.Collection;

import com.almansa.cyklumcodechallengeapi.game.domain.Round;

public interface GameHistoryRepository {
	public void persistRound(Round round);
	public Collection<Round> getRounds();
}

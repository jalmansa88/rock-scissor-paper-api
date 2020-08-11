package com.almansa.cyklumcodechallengeapi.gamehistory.repository;

import com.almansa.cyklumcodechallengeapi.gamehistory.domain.GameHistory;
import com.almansa.cyklumcodechallengeapi.round.domain.Round;

public interface GameHistoryRepository {
	public void persistRound(Round round);
	public GameHistory getHistory();
}

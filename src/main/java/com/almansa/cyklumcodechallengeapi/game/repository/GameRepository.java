package com.almansa.cyklumcodechallengeapi.game.repository;

import com.almansa.cyklumcodechallengeapi.game.domain.Game;

public interface GameRepository {
	public Game getSessionGame(Long sessionId);
	
	public void persistSessionGame(Game game, Long sessionId);
}

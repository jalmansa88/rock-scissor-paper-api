package com.almansa.cyklumcodechallengeapi.game.repository;

import com.almansa.cyklumcodechallengeapi.game.domain.Game;

public interface GameRepository {
	public Game getSessionGame(Long sessionId);
	public void persistSessionGame(Long sessionId, Game game);
	public void clearSessionGame(Long sessionId);
}

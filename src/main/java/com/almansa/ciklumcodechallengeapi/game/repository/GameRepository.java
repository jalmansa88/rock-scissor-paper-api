package com.almansa.ciklumcodechallengeapi.game.repository;

import com.almansa.ciklumcodechallengeapi.game.domain.Game;

public interface GameRepository {
	public Game getSessionGame(Long sessionId);
	public void persistSessionGame(Long sessionId, Game game);
	public void clearSessionGame(Long sessionId);
}

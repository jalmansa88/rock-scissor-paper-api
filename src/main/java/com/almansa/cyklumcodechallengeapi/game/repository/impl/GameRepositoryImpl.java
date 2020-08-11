package com.almansa.cyklumcodechallengeapi.game.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.almansa.cyklumcodechallengeapi.game.domain.Game;
import com.almansa.cyklumcodechallengeapi.game.repository.GameRepository;

@Component
public class GameRepositoryImpl implements GameRepository{

	private Map<Long, Game> sessionGames;
	
	public GameRepositoryImpl() {
		this.sessionGames = new HashMap<Long, Game>();
	}

	@Override
	public Game getSessionGame(Long sessionId) {
		return sessionGames.get(sessionId);
	}

	@Override
	public void persistSessionGame(Game game, Long sessionId) {
		sessionGames.put(sessionId, game);
	}
}

package com.almansa.ciklumcodechallengeapi.game.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.almansa.ciklumcodechallengeapi.game.domain.Game;
import com.almansa.ciklumcodechallengeapi.game.repository.GameRepository;

@Component
public class GameRepositoryImpl implements GameRepository {

	private Map<Long, Game> sessionGames;

	public GameRepositoryImpl() {
		this.sessionGames = new HashMap<Long, Game>();
	}

	@Override
	public Game getSessionGame(Long sessionId) {
		return sessionGames.get(sessionId);
	}

	@Override
	public void persistSessionGame(Long sessionId, Game game) {
		sessionGames.put(sessionId, game);
	}

	@Override
	public void clearSessionGame(Long sessionId) {
		sessionGames.remove(sessionId);
	}
}

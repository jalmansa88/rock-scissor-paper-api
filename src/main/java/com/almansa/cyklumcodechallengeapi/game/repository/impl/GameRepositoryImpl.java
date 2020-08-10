package com.almansa.cyklumcodechallengeapi.game.repository.impl;

import org.springframework.stereotype.Component;

import com.almansa.cyklumcodechallengeapi.game.domain.Game;
import com.almansa.cyklumcodechallengeapi.game.repository.GameRepository;

@Component
public class GameRepositoryImpl implements GameRepository{

	@Override
	public Game getSessionGame(Long sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persistSessionGame(Game game, Long sessionId) {
		// TODO Auto-generated method stub
		
	}
}

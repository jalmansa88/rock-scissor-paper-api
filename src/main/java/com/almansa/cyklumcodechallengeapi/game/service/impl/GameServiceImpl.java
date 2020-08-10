package com.almansa.cyklumcodechallengeapi.game.service.impl;

import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almansa.cyklumcodechallengeapi.game.domain.Game;
import com.almansa.cyklumcodechallengeapi.game.repository.GameRepository;
import com.almansa.cyklumcodechallengeapi.game.service.GameService;

@Service
public final class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public Game playRound(Long sessionId) {
		Game game = findOrInitSessionGame(sessionId);
		game.playRound();
		gameRepository.persistSessionGame(game, sessionId);
		//persist historyGames
		return game;
	}

	@Override
	public Game getSessionGame(Long sessionId) {
		return gameRepository.getSessionGame(sessionId);
	}
	
	private Game findOrInitSessionGame(Long sessionId) {
		Game sessionGame = gameRepository.getSessionGame(sessionId);
		if(isNull(sessionGame)) {
			//sessionGame = init game
		}
		return sessionGame;
	}
	
}

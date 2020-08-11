package com.almansa.cyklumcodechallengeapi.game.service.impl;

import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almansa.cyklumcodechallengeapi.game.domain.Game;
import com.almansa.cyklumcodechallengeapi.game.repository.GameRepository;
import com.almansa.cyklumcodechallengeapi.game.service.GameService;
import com.almansa.cyklumcodechallengeapi.gamehistory.repository.GameHistoryRepository;
import com.almansa.cyklumcodechallengeapi.player.domain.Player;
import com.almansa.cyklumcodechallengeapi.player.strategy.impl.RandomShapePlayerStrategy;
import com.almansa.cyklumcodechallengeapi.player.strategy.impl.RockShapePlayerStrategy;
import com.almansa.cyklumcodechallengeapi.round.domain.Round;
import com.almansa.cyklumcodechallengeapi.rule.GameRuleService;

@Service
public final class GameServiceImpl implements GameService {
	
	@Autowired
	private GameRuleService gameRule;
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private GameHistoryRepository gameHistoryRepository;

	@Override
	public Game getSessionGame(Long sessionId) {
		return gameRepository.getSessionGame(sessionId);
	}

	@Override
	public Game playRound(Long sessionId) {
		Game sessionGame = findOrInitSessionGame(sessionId);
		Round playedRound = sessionGame.playRound();
		gameRepository.persistSessionGame(sessionGame, sessionId);
		gameHistoryRepository.persistRound(playedRound);
		return sessionGame;
	}

	private Game findOrInitSessionGame(Long sessionId) {
		Game sessionGame = gameRepository.getSessionGame(sessionId);
		if (isNull(sessionGame)) {
			sessionGame = initGame();
		}
		return sessionGame;
	}

	// In order to loose coupling with Player and Game classes,
	// this method may be delegated in a GameInitializer service
	private Game initGame() {
		Player player1Random = new Player(new RandomShapePlayerStrategy());
		Player player2Rock = new Player(new RockShapePlayerStrategy());
		return new Game(player1Random, player2Rock, gameRule);
	}

}

package com.almansa.ciklumcodechallengeapi.game.service.impl;

import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almansa.ciklumcodechallengeapi.game.domain.Game;
import com.almansa.ciklumcodechallengeapi.game.domain.Round;
import com.almansa.ciklumcodechallengeapi.game.repository.GameRepository;
import com.almansa.ciklumcodechallengeapi.game.rule.GameRule;
import com.almansa.ciklumcodechallengeapi.game.service.GameService;
import com.almansa.ciklumcodechallengeapi.gamehistory.repository.GameHistoryRepository;
import com.almansa.ciklumcodechallengeapi.player.domain.Player;
import com.almansa.ciklumcodechallengeapi.player.strategy.impl.RandomShapePlayerStrategy;
import com.almansa.ciklumcodechallengeapi.player.strategy.impl.RockShapePlayerStrategy;

@Service
public final class GameServiceImpl implements GameService {

	@Autowired
	private GameRule gameRule;
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private GameHistoryRepository gameHistoryRepository;
	
	public GameServiceImpl(GameRule gameRule, GameRepository gameRepository,
			GameHistoryRepository gameHistoryRepository) {
		this.gameRule = gameRule;
		this.gameRepository = gameRepository;
		this.gameHistoryRepository = gameHistoryRepository;
	}

	@Override
	public Game getSessionGame(Long sessionId) {
		return gameRepository.getSessionGame(sessionId);
	}

	@Override
	public Game playRound(Long sessionId) {
		Game sessionGame = findOrInitSessionGame(sessionId);
		Round playedRound = sessionGame.playRound();
		gameRepository.persistSessionGame(sessionId, sessionGame);
		gameHistoryRepository.persistRound(playedRound);
		return sessionGame;
	}

	@Override
	public void clearSessionGame(Long sessionId) {
		gameRepository.clearSessionGame(sessionId);
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

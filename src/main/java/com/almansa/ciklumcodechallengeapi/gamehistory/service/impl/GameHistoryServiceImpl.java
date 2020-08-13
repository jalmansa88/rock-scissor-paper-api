package com.almansa.ciklumcodechallengeapi.gamehistory.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.almansa.ciklumcodechallengeapi.game.domain.Round;
import com.almansa.ciklumcodechallengeapi.gamehistory.domain.GameHistory;
import com.almansa.ciklumcodechallengeapi.gamehistory.repository.GameHistoryRepository;
import com.almansa.ciklumcodechallengeapi.gamehistory.service.GameHistoryService;

@Component
public class GameHistoryServiceImpl implements GameHistoryService {

	private GameHistoryRepository gameHistoryRepository;
	
	@Autowired
	public GameHistoryServiceImpl(GameHistoryRepository gameHistoryRepository) {
		this.gameHistoryRepository = gameHistoryRepository;
	}

	@Override
	public GameHistory getGameHistory() {
		Collection<Round> rounds = gameHistoryRepository.getRounds();
		return new GameHistory(rounds);
	}
}

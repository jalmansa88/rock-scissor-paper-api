package com.almansa.cyklumcodechallengeapi.gamehistory.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.almansa.cyklumcodechallengeapi.game.domain.Round;
import com.almansa.cyklumcodechallengeapi.gamehistory.domain.GameHistory;
import com.almansa.cyklumcodechallengeapi.gamehistory.repository.GameHistoryRepository;
import com.almansa.cyklumcodechallengeapi.gamehistory.service.GameHistoryService;

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

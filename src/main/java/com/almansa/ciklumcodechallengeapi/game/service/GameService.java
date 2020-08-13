package com.almansa.ciklumcodechallengeapi.game.service;

import com.almansa.ciklumcodechallengeapi.game.domain.Game;

public interface GameService {
	public Game getSessionGame(Long sessionId);
	public Game playRound(Long sessionId);
	public void clearSessionGame(Long sessionId);
}

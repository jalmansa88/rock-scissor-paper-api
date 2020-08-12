package com.almansa.cyklumcodechallengeapi.game.service;

import com.almansa.cyklumcodechallengeapi.game.domain.Game;

public interface GameService {
	public Game getSessionGame(Long sessionId);
	public Game playRound(Long sessionId);
	public void clearSessionGame(Long sessionId);
}

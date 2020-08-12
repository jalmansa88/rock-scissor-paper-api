package com.almansa.cyklumcodechallengeapi.game.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.almansa.cyklumcodechallengeapi.game.domain.Game;
import com.almansa.cyklumcodechallengeapi.game.repository.impl.GameRepositoryImpl;

public class GameRepositoryTest {

	private static final Long GAMESESSION_ID = 12345L;

	private GameRepository gameRepository;

	@BeforeEach
	public void setUp() {
		gameRepository = new GameRepositoryImpl();
	}

	@Test
	public void shouldReturnNull_noGameFound() {
		Game recoveredGame = gameRepository.getSessionGame(GAMESESSION_ID);

		assertEquals(null, recoveredGame);
	}

	@Test
	public void shouldPersistAndReturnSessionGame() {
		Game sessionGame = mock(Game.class);

		gameRepository.persistSessionGame(sessionGame, GAMESESSION_ID);
		Game returnedGame = gameRepository.getSessionGame(GAMESESSION_ID);

		assertEquals(sessionGame, returnedGame);
	}

	@Test
	public void shouldPersistAndClearSessionGame() {
		Game sessionGame = mock(Game.class);

		gameRepository.persistSessionGame(sessionGame, GAMESESSION_ID);
		gameRepository.clearSessionGame(GAMESESSION_ID);
		Game recoveredGame = gameRepository.getSessionGame(GAMESESSION_ID);

		assertEquals(null, recoveredGame);
	}

}

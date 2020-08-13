package com.almansa.ciklumcodechallengeapi.game.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.almansa.ciklumcodechallengeapi.game.domain.Game;
import com.almansa.ciklumcodechallengeapi.game.domain.Round;
import com.almansa.ciklumcodechallengeapi.game.repository.GameRepository;
import com.almansa.ciklumcodechallengeapi.game.rule.GameRule;
import com.almansa.ciklumcodechallengeapi.game.service.GameService;
import com.almansa.ciklumcodechallengeapi.game.service.impl.GameServiceImpl;
import com.almansa.ciklumcodechallengeapi.gamehistory.repository.GameHistoryRepository;

@DisplayName("Test suite for GameService")
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class GameServiceTest {

	private static final Long GAMESESSION_ID = 12345L;

	@Mock
	private GameRule gameRule;
	@Mock
	private GameRepository gameRepository;
	@Mock
	private GameHistoryRepository gameHistoryRepository;

	private GameService gameService;
	
	@BeforeEach
	public void setUp() {
		gameService = new GameServiceImpl(gameRule, gameRepository, gameHistoryRepository);
	}

	@Test
	public void shouldGetSessionGame() {
		Game game = mock(Game.class);
		when(gameRepository.getSessionGame(GAMESESSION_ID)).thenReturn(game);

		Game recoveredGame = gameService.getSessionGame(GAMESESSION_ID);

		assertEquals(game, recoveredGame);
	}

	@Test
	public void shouldRecoverGameAndPlayRound() {
		Game sessionGame = mock(Game.class);
		Round playedRound = mock(Round.class);
		when(gameRepository.getSessionGame(GAMESESSION_ID)).thenReturn(sessionGame);
		when(sessionGame.playRound()).thenReturn(playedRound);

		gameService.playRound(GAMESESSION_ID);

		assertEquals(sessionGame, sessionGame);
		verify(gameRepository, atMostOnce()).persistSessionGame(GAMESESSION_ID, sessionGame);
		verify(gameHistoryRepository, atMostOnce()).persistRound(playedRound);
	}

	@Test
	public void shouldInitGameAndPlayRound() {
		when(gameRepository.getSessionGame(GAMESESSION_ID)).thenReturn(null);

		Game newGame = gameService.playRound(GAMESESSION_ID);

		assertNotNull(newGame);
	}

	@Test
	public void shouldClearSessionGame() {
		doNothing().when(gameRepository).clearSessionGame(GAMESESSION_ID);

		gameService.clearSessionGame(GAMESESSION_ID);

		verify(gameRepository, atMostOnce()).clearSessionGame(GAMESESSION_ID);
	}

}

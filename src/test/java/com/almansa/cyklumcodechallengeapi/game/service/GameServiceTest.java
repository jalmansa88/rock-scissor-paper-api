package com.almansa.cyklumcodechallengeapi.game.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.almansa.cyklumcodechallengeapi.game.domain.Game;
import com.almansa.cyklumcodechallengeapi.game.repository.GameRepository;
import com.almansa.cyklumcodechallengeapi.game.service.impl.GameServiceImpl;
import com.almansa.cyklumcodechallengeapi.gamehistory.repository.GameHistoryRepository;
import com.almansa.cyklumcodechallengeapi.round.domain.Round;
import com.almansa.cyklumcodechallengeapi.rule.GameRuleService;

@DisplayName("Test suite for GameService")
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class GameServiceTest {
	private static final Long GAMESESSION_ID = 12345L;

	@Mock
	private GameRuleService gameRule;
	@Mock
	private GameRepository gameRepository;
	@Mock
	private GameHistoryRepository gameHistoryRepository;

	@InjectMocks
	private GameService gameService = new GameServiceImpl();

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
		verify(gameRepository, atMostOnce()).persistSessionGame(sessionGame, GAMESESSION_ID);
		verify(gameHistoryRepository, atMostOnce()).persistRound(playedRound);
	}
	
	@Test
	public void shouldInitGameAndPlayRound() {
		when(gameRepository.getSessionGame(GAMESESSION_ID)).thenReturn(null);
		
		Game newGame = gameService.playRound(GAMESESSION_ID);
		
		assertNotNull(newGame);
	}

}

package com.almansa.ciklumcodechallengeapi.gamehistory.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.almansa.ciklumcodechallengeapi.game.domain.Round;
import com.almansa.ciklumcodechallengeapi.gamehistory.domain.GameHistory;
import com.almansa.ciklumcodechallengeapi.gamehistory.repository.GameHistoryRepository;
import com.almansa.ciklumcodechallengeapi.gamehistory.service.GameHistoryService;
import com.almansa.ciklumcodechallengeapi.gamehistory.service.impl.GameHistoryServiceImpl;

@DisplayName("Test suite for GameHistoryService")
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class GameHistoryServiceTest {

	@Mock
	private GameHistoryRepository gameHistoryRepo;
	
	GameHistoryService service;
	
	@BeforeEach
	public void setUp() {
		service = new GameHistoryServiceImpl(gameHistoryRepo);
	}
			
	@Test
	@SuppressWarnings("unchecked")
	public void shouldReturnGameHistory() {
		Collection<Round> rounds = mock(Collection.class);
		
		when(gameHistoryRepo.getRounds()).thenReturn(rounds);
		GameHistory gameHistory = service.getGameHistory();
		
		assertNotNull(gameHistory);
	}
}

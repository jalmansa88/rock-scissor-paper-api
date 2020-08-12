package com.almansa.cyklumcodechallengeapi.gamehistory.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.almansa.cyklumcodechallengeapi.game.domain.Round;
import com.almansa.cyklumcodechallengeapi.player.domain.RoundWinner;

public class GameHistoryTest {

	private GameHistory gameHistory;

	@BeforeEach
	public void setUp() {
		Round round1 = mock(Round.class);
		Round round2 = mock(Round.class);
		Round round3 = mock(Round.class);

		Collection<Round> rounds = Arrays.asList(round1, round2, round3);

		when(round1.getWinner()).thenReturn(RoundWinner.PLAYER_ONE);
		when(round2.getWinner()).thenReturn(RoundWinner.PLAYER_ONE);
		when(round3.getWinner()).thenReturn(RoundWinner.DRAW);

		gameHistory = new GameHistory(rounds);
	}

	@Test
	public void shouldReturnNumTotalRounds() {
		assertEquals(3, gameHistory.getNumTotalRounds());
	}

	@Test
	public void shouldReturnNumDraws() {
		assertEquals(1, gameHistory.getNumDraws());
	}

	@Test
	public void shouldReturnNumWinsPlayerOne() {
		assertEquals(2, gameHistory.getNumWinsPlayerOne());
	}

	@Test
	public void shouldReturnNumWinsPlayerTwo() {
		assertEquals(0, gameHistory.getNumWinsPlayerTwo());
	}

}

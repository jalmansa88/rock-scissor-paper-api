package com.almansa.cyklumcodechallengeapi.game.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.almansa.cyklumcodechallengeapi.game.domain.Game;
import com.almansa.cyklumcodechallengeapi.game.rule.impl.GameRuleImpl;
import com.almansa.cyklumcodechallengeapi.game.service.GameService;
import com.almansa.cyklumcodechallengeapi.player.domain.Player;
import com.almansa.cyklumcodechallengeapi.player.strategy.impl.RockShapePlayerStrategy;

@WebMvcTest(GameController.class)
public class GameControllerTest {

	private static final String BASE_URL = "/game";
	private static final String GAMESESSION_ID = "12345";
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GameService service;
	
	@Test
	public void shouldPerformGetAndRetrieveSessionGame() throws Exception {
		Player player1 = new Player(new RockShapePlayerStrategy());
		Player player2 = new Player(new RockShapePlayerStrategy());
		Game game = new Game(player1, player2, new GameRuleImpl());
		
		game.playRound();
		when(service.getSessionGame(Long.valueOf(GAMESESSION_ID))).thenReturn(game);
		
		mockMvc
			.perform(get(BASE_URL).param("sessionId", GAMESESSION_ID))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(content().string(containsString("DRAW")));
	}

	@Test
	public void shouldReturnBadRequest_invalidSessionType() throws Exception {
		mockMvc
		.perform(get(BASE_URL).param("sessionId", "adadsd"))
		.andExpect(status().isBadRequest());
	}

	@Test
	public void shouldReturnBadRequest_missingSessionId() throws Exception {
		mockMvc
		.perform(get(BASE_URL))
		.andExpect(status().isBadRequest());
	}
}

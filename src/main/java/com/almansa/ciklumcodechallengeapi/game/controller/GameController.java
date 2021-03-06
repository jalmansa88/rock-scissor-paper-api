package com.almansa.ciklumcodechallengeapi.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.almansa.ciklumcodechallengeapi.game.domain.Game;
import com.almansa.ciklumcodechallengeapi.game.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public ResponseWrapper getGameSession(@RequestParam Long sessionId) {
		return new ResponseWrapper(gameService.getSessionGame(sessionId));
	}
	
	@PostMapping("/play")
	public Game playRound(@RequestParam @NonNull Long sessionId) {
		return gameService.playRound(sessionId);
	}

	@DeleteMapping
	public void clearSessionGame(@RequestParam @NonNull Long sessionId) {
		gameService.clearSessionGame(sessionId);
	}
}

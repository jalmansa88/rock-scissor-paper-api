package com.almansa.cyklumcodechallengeapi.gamehistory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almansa.cyklumcodechallengeapi.gamehistory.domain.GameHistory;
import com.almansa.cyklumcodechallengeapi.gamehistory.service.GameHistoryService;

@RestController
@RequestMapping("/history")
public class GameHistoryController {
	
	@Autowired
	private GameHistoryService gameHistoryService;
	
	@GetMapping
	public GameHistory getGameHistory() {
		return gameHistoryService.getGameHistory();
	}
}

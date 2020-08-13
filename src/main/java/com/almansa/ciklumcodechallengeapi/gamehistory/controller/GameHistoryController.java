package com.almansa.ciklumcodechallengeapi.gamehistory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almansa.ciklumcodechallengeapi.gamehistory.domain.GameHistory;
import com.almansa.ciklumcodechallengeapi.gamehistory.service.GameHistoryService;

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

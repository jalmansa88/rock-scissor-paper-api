package com.almansa.cyklumcodechallengeapi.rule;

import com.almansa.cyklumcodechallengeapi.game.domain.Shape;

public interface GameRuleService {
	int getWinner(Shape selection, Shape selection2);
}

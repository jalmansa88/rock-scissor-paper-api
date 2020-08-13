package com.almansa.ciklumcodechallengeapi.game.rule;

import com.almansa.ciklumcodechallengeapi.game.domain.Shape;
import com.almansa.ciklumcodechallengeapi.player.domain.RoundWinner;

public interface GameRule {
	RoundWinner getWinner(Shape selection, Shape selection2);
}

package com.almansa.cyklumcodechallengeapi.game.rule;

import com.almansa.cyklumcodechallengeapi.game.domain.Shape;
import com.almansa.cyklumcodechallengeapi.player.domain.RoundWinner;

public interface GameRule {
	RoundWinner getWinner(Shape selection, Shape selection2);
}

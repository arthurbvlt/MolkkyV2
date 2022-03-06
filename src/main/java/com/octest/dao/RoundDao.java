package com.octest.dao;

import com.octest.beans.Game;
import com.octest.beans.Round;
import com.octest.beans.Team;

public interface RoundDao {
	
	void create(Round round);
	
	Round getLastByNameAndGame(Game game, Team team);
	Round getByNameAndGameAndNbRound(Game game, Team team, int nbRound);

}

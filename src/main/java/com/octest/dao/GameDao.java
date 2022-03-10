package com.octest.dao;

import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Game;

public interface GameDao {
	
	void create(Game game);
	void putAWinner(int gameid, int teamid);
	
	Integer getIdByCode(String code);
	List<Game> getGamesByTeamId(int id);

}

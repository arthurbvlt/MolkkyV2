package com.octest.dao;

import java.util.ArrayList;

import com.octest.beans.Game;

public interface GameDao {
	
	void create(Game game);
	void putAWinner(int id);
	
	Integer getIdByCode(String code);
	ArrayList<Game> getGamesByTeamId(int id);

}

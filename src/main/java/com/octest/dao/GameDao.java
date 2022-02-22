package com.octest.dao;

import com.octest.beans.Game;

public interface GameDao {
	
	void create(Game game);
	
	Game getById(int id);

}

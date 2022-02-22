package com.octest.dao;

import com.octest.beans.Game;
import com.octest.beans.Round;
import com.octest.beans.Team;

public class RoundDaoImpl implements RoundDao{

	 private DaoFactory daoFactory;

	 RoundDaoImpl(DaoFactory daoFactory) {
	        this.daoFactory = daoFactory;
	    }
	    
	@Override
	public void create(Round round) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Round getByNameAndGame(Game game, Team team) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.octest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.octest.beans.Game;

public class GameDaoImpl implements GameDao{

	
	 private DaoFactory daoFactory;

	public  GameDaoImpl(DaoFactory daoFactory) {
	        this.daoFactory = daoFactory;
	    }
	 
	 
	@Override
	public void create(Game game) {
		  Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO game(team1Id, team2Id, teamWinnerId) VALUES(?, ?, ?);");
	            preparedStatement.setInt(1, game.getTeam1().getId());
	            preparedStatement.setInt(2, game.getTeam2().getId());
	            preparedStatement.setInt(3, (Integer) null);

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		
	}

	@Override
	public Game getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

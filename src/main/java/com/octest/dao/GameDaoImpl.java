package com.octest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	            preparedStatement = connexion.prepareStatement("INSERT INTO game(team1Id, team2Id, code) VALUES(?, ?, ?);");
	            preparedStatement.setInt(1, game.getTeam1().getId());
	            preparedStatement.setInt(2, game.getTeam2().getId());
	            preparedStatement.setString(3, game.code);

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		
	}


	@Override
	public Integer getIdByCode(String code) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
        	 
        	connection = daoFactory.getConnection();
        	preparedStatement = connection.prepareStatement("SELECT id "
        			+ "FROM game "
        			+ "WHERE code = ? ;");
        	preparedStatement.setString(1, code);  
        	
        	result =  preparedStatement.executeQuery();
            // TODO deal with the idEstablishment

           if(result.next()) {
               int id = result.getInt("id");
            
        	   return id;
           }else {
        	   return null;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

}




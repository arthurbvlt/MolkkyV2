package com.octest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO round(gameId, currentTeamId, score, nbRound, countZero, totalScore) VALUES(?, ?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, round.getGame().getId());
            preparedStatement.setInt(2, round.getTeam().getId());
            preparedStatement.setInt(3, round.getScore());
            preparedStatement.setInt(4, round.getNbRound());
            preparedStatement.setInt(5, round.getCountZero());
            preparedStatement.setInt(6, round.getTotalScore());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }		
	}

	@Override
	public Round getByNameAndGame(Game game, Team team) {
		// TODO Auto-generated method stub
		
		//SELECT id FROM your_table WHERE id = (SELECT MAX(id) FROM your_table)
		
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
        	 
        	connection = daoFactory.getConnection();
        	preparedStatement = connection.prepareStatement("SELECT * "
        			+ "FROM round "
        			+ "WHERE currentTeamId = ? AND gameId = ? ORDER BY nbRound DESC;");
        	preparedStatement.setInt(1, team.getId());
        	preparedStatement.setInt(2, game.getId());  
        	
        	
        	result =  preparedStatement.executeQuery();
            // TODO deal with the idEstablishment

        	if(result.next()) {
        	   
        		   int id = result.getInt("id");
                   int score = result.getInt("score");
                   int nbRound = result.getInt("nbRound");
                   int countZero = result.getInt("countZero");
                   int totalScore = result.getInt("totalScore");
                   
                   
                   Round round = new Round(id, team, game, score, totalScore, nbRound, countZero);
                
            	   return round;

              
           }else {
        	   return null;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
	
}

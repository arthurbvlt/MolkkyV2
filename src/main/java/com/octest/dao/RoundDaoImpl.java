package com.octest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            preparedStatement.setInt(1, round.game.getId());
            preparedStatement.setInt(2, round.team.getId());
        	System.out.println(round.score + "round.score"); 
            preparedStatement.setInt(3, round.score);
            preparedStatement.setInt(4, round.nbRound);
            preparedStatement.setInt(5, round.countZero);
            preparedStatement.setInt(6, round.totalScore);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }		
	}

	@Override
	public Round getByNameAndGame(Game game, Team team) {
		// TODO Auto-generated method stub
		return null;
	}

}

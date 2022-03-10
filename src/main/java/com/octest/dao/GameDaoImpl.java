package com.octest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Game;
import com.octest.beans.Round;
import com.octest.beans.Team;

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
	        }finally {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connexion != null) {
						connexion.close();
					}

				}catch (Exception e) {
					// throw new DaoException("Message d'erreur :" + e.getMessage());
				}
			}

		
	}
	
	@Override
	public void putAWinner(int gameid, int teamid) {
		  Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("UPDATE  game SET teamWinnerId =  ? "
	            		+ "WHERE game.id = ? ;");
	            preparedStatement.setInt(1, teamid);
	            preparedStatement.setInt(2, gameid);

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

           if(result.next()) {
               int id = result.getInt("id");
            
        	   return id;
           }else {
        	   return null;
           }
        } catch (SQLException e) {
//			throw new DaoException("Impossible de communiquer avec la base de données");
        }finally {
			try {
				if (result != null) {
					result.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			}catch (SQLException e) {
//				throw new DaoException("Message d'erreur :" + e.getMessage());
			}
		}
		return null;
	}	
	
	
	@Override
	public List<Game> getGamesByTeamId(int id) {

		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        List<Game> games = new ArrayList<Game>();	
 	   	Team teamWinner; 

        try {
        	 
        	connection = daoFactory.getConnection();
        	preparedStatement = connection.prepareStatement("SELECT * "
        			+ "FROM game "
        			+ "WHERE team1Id = ? OR team2Id = ?;");
        	preparedStatement.setInt(1, id);
        	preparedStatement.setInt(2, id);  

        	
        	result =  preparedStatement.executeQuery();

        	while(result.next()) {
        				
        		   int idGame = result.getInt("id");
                   int team1Id = result.getInt("team1Id");
                   int team2Id = result.getInt("team2Id");
                   int teamWinnerId = result.getInt("teamWinnerId");
                   String code = result.getString("code");
                   
                   DaoFactory dao = DaoFactory.getInstance();  //a voir si on peut l'appeler ici, sinon il faudra faire plusieurs fonctions GameDao

                   Team team1 = dao.getTeamDao().getTeamById(team1Id);
                   Team team2 = dao.getTeamDao().getTeamById(team2Id);
                   if(teamWinnerId == team1.getId()) {
                	   teamWinner = team1;
                   }else {
                	   teamWinner = team2;
                   }         
                   
                   Game game = new Game(idGame, team1, team2, teamWinner, code);
                
                   games.add(game);
        	}
        } catch (SQLException e) {
//			throw new DaoException("Message d'erreur :" + e.getMessage());
        }
		return games;
	}

}




package com.octest.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.octest.beans.Team;


public class TeamDaoImpl implements TeamDao {
    private DaoFactory daoFactory;

    TeamDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(Team team) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO team(name) VALUES(?);");
            preparedStatement.setString(1, team.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<String> lister() {
        List<String> names = new ArrayList<String>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT name FROM team;");

            while (resultat.next()) {
                String name = resultat.getString("name");


                names.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }

	@Override
	public Integer getIdByName(String name) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
        	 
        	connection = daoFactory.getConnection();
        	preparedStatement = connection.prepareStatement("SELECT id "
        			+ "FROM team "
        			+ "WHERE name = ? ;");
        	preparedStatement.setString(1, name);  
        	
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
	
	@Override
	public Team getTeamById(int id) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
        	 
        	connection = daoFactory.getConnection();
        	preparedStatement = connection.prepareStatement("SELECT * "
        			+ "FROM team "
        			+ "WHERE id = ? ;");
        	preparedStatement.setInt(1, id);  
        	
        	result =  preparedStatement.executeQuery();

           if(result.next()) {
               String name = result.getString("name");

               Team team = new Team(id, name);
               
        	   return team;
           }else {
        	   return null;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public void ajouter(List<String> names) {
		Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        Iterator<String> it = names.iterator();

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO team(name) VALUES(?);");
	           
	            while(it.hasNext()) {
	            	String name = it.next();
	            	 preparedStatement.setString(1, name);
	            	 preparedStatement.addBatch();
	            }
	           
	            preparedStatement.executeBatch();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

}
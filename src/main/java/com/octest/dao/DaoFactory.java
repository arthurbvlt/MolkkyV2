package com.octest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }
        System.out.println("oi");
        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/molkkyv2", "root", "");   // changement de mdp et id pour se connecter Zara ! 
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // R�cup�ration du Dao
    public TeamDao getTeamDao() {
        return new TeamDaoImpl(this);
    }
    
    public GameDao getGameDao() {
    	return new GameDaoImpl(this);
    }
    
    public RoundDao getRoundDao() {
    	return new RoundDaoImpl(this);
    }
}
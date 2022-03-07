package com.octest.dao;

import java.util.List;

import com.octest.beans.Team;

public interface TeamDao {
    void ajouter( Team team );
    
    void ajouter(List<String> name);
    List<Team> lister();
    
    Integer getIdByName(String name);
	Team getTeamById(int id);

}
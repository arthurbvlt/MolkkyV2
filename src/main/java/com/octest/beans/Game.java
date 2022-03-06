package com.octest.beans;

public class Game {
	
	public int id;
	public Team team1;
	public Team team2;
	public Team teamWinner;
	public String code;
	
	
	public Game(Team team1, Team team2, Team teamWinner, String code) {
		super();
		this.team1 = team1;
		this.team2 = team2;
		this.teamWinner = teamWinner;
		this.code = code;
	}
	
	




	public Game(int id, Team team1, Team team2, Team teamWinner, String code) {
		super();
		this.id = id;
		this.team1 = team1;
		this.team2 = team2;
		this.teamWinner = teamWinner;
		this.code = code;
	}



	public Game() {
		super();
	}
	
	
	public Team getTeam1() {
		return team1;
	}
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
	public Team getTeam2() {
		return team2;
	}
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}
	public Team getTeamWinner() {
		return teamWinner;
	}
	public void setTeamWinner(Team teamWinner) {
		this.teamWinner = teamWinner;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}

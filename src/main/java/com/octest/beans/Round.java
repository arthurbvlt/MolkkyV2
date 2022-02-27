package com.octest.beans;

public class Round {

	public int id;
	public Team team;
	public Game game;
	public int score;
	public int totalScore;
	public int nbRound;
	public int countZero;
	
	
	public Round(Team team, Game game, int score, int totalScore, int nbRound, int countZero) {
		super();
		this.team = team;
		this.game = game;
		this.score = score;
		this.totalScore = totalScore;
		this.nbRound = nbRound;
		this.countZero = countZero;
	}
	
	
	public Round(int id, Team team, Game game, int score, int totalScore, int nbRound, int countZero) {
		super();
		this.id = id;
		this.team = team;
		this.game = game;
		this.score = score;
		this.totalScore = totalScore;
		this.nbRound = nbRound;
		this.countZero = countZero;
	}


	public Round() {
		super();
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getTotalScore() {
		return totalScore;
	}


	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}


	public int getNbRound() {
		return nbRound;
	}


	public void setNbRound(int nbRound) {
		this.nbRound = nbRound;
	}


	public int getCountZero() {
		return countZero;
	}


	public void setCountZero(int countZero) {
		this.countZero = countZero;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
}

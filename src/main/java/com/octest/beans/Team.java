package com.octest.beans;

public class Team {
	
	protected int id;
	protected String name;
	protected int score;
	protected int turn;
	protected boolean isWinner;
	protected boolean isTurn; 
	protected int countZero;
	
	public Team(String name) {
		super();
		this.name = name;
		this.score = 0;
		this.turn = 1;
		this.isWinner = false;
		this.isTurn = false;
		this.countZero = 0;
	}
	
	
	
	public Team(String name, int score, int turn, boolean isWinner, boolean isTurn, int countZero) {
		super();
		this.name = name;
		this.score = score;
		this.turn = turn;
		this.isWinner = isWinner;
		this.isTurn = isTurn;
		this.countZero = countZero;
	}



	public Team(int id, String name, int score, int turn, boolean isWinner, boolean isTurn, int countZero) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.turn = turn;
		this.isWinner = isWinner;
		this.isTurn = isTurn;
		this.countZero = countZero;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Team(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public int getCountZero() {
		return this.countZero;
	}
	public void setCountZero(int countZero) {
		this.countZero = countZero;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}



	public int getTurn() {
		return turn;
	}



	public void setTurn(int turn) {
		this.turn = turn;
	}



	public boolean getIsWinner() {
		return isWinner;
	}



	public void setIsWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	public boolean getIsTurn() {
		return isTurn;
	}



	public void setIsTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}
	

}

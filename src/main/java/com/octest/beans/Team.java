package com.octest.beans;

public class Team {
	
	protected int id;
	protected String name;
	protected int turn;
	protected boolean isTurn; 
	
	public Team(String name) {
		super();
		this.name = name;
		this.turn = 1;
		this.isTurn = false;
	}
	public Team(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public boolean getIsTurn() {
		return isTurn;
	}
	public void setIsTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}
	

}

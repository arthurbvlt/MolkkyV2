package com.octest.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.beans.Game;
import com.octest.beans.Round;
import com.octest.beans.Team;

@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		this.getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();

	     Team team1 = (Team) session.getAttribute("team1");
	     Team team2 = (Team) session.getAttribute("team2");
		
	     Round round = (Round) session.getAttribute("round");
	     
	     Game game = round.getGame();
	     
	     int score = Integer.valueOf(request.getParameter("score"));
	     
	     	//new 
			round.setScore(score);
			round.setTotalScore(round.getTotalScore()+ score);
			int nbRound = round.getNbRound();
			//send db  ff
			
			if(game.getTeam1().getName().equals(round.getTeam().getName())) {
				round = new Round(team2, game, 0, nbRound+1, 0, 0 );
			}
			
	     
		if(!team1.getIsTurn()) {
			team1.setScore(team1.getScore()+score) ;
			
			team1.setTurn(team1.getTurn()+1);
			if (score == 0){
			 	team1.setCountZero(team1.getCountZero()+1);
			 }

			 if (team1.getCountZero() == 3){
				 team1.setScore(0);
				 team1.setCountZero(0);
			 }
		}else if (!team2.getIsTurn()) {
			team2.setScore(team2.getScore()+score);
			team2.setTurn(team2.getTurn()+1);
			if (score == 0){
			 	team2.setCountZero(team2.getCountZero()+1);
			 }

			 if (team2.getCountZero() == 3){
				 team2.setScore(0);
				 team2.setCountZero(0);
			 }
		}
		
		if(team1.getScore() >50) {
			team1.setScore(team1.getScore() - 25 );
		}else if(team1.getScore()  == 50) {
			team1.setIsWinner(true);
			System.out.println("gagnant1");
			
			session.setAttribute("team1", team1);
			session.setAttribute("team2", team2);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
		}
		
		if(team2.getScore() >50) {
			team2.setScore(team2.getScore() - 25 );
		}else if(team2.getScore()  == 50) {
			team2.setIsWinner(true);
			
			session.setAttribute("team1", team1);
			session.setAttribute("team2", team2);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
			
		}
		
		if(request.getParameter("finish") != null ) {
			if(team1.getScore()>team2.getScore()) {
				team1.setIsWinner(true);
				session.setAttribute("team1", team1);
				session.setAttribute("team2", team2);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
			}
			else if(team1.getScore()<team2.getScore()){
				team2.setIsWinner(true);
				session.setAttribute("team1", team1);
				session.setAttribute("team2", team2);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
			}
			else {
				session.setAttribute("team1", team1);
				session.setAttribute("team2", team2);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
			}
		}
		
		session.setAttribute("team1", team1);    //�a renvoie � la Servlet l'attribut team1
		session.setAttribute("team2", team2);
		session.setAttribute("round", round);
		this.getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
	
    }
 
}

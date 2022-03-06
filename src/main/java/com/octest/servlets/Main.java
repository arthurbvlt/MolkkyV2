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
import com.octest.dao.DaoFactory;

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

    	DaoFactory dao = DaoFactory.getInstance();
    	
     	//new 
		round.setScore(score);
		
		Round roundOld = dao.getRoundDao().getLastByNameAndGame(game, round.getTeam());
		
		
		if (roundOld!= null) {
			round.setTotalScore(roundOld.getTotalScore() + score);
			round.setNbRound(roundOld.getNbRound()+1);
			round.setTotalScore(roundOld.getTotalScore() + score );  //pour faire des tests j'ai mis � 50 ne pas oublier d'enlever
			round.setNbRound(roundOld.getNbRound()+1);
		}else {
			round.setTotalScore( score);
		}
		
		
		if(round.getTotalScore() == 10) {
			 game.setTeamWinner(round.getTeam());
			 dao.getGameDao().putAWinner(game.getTeamWinner().getId());
			 System.out.println("gagnant: " + game.getTeamWinner().getName());
			 session.setAttribute("team1", team1);
			 session.setAttribute("team2", team2);
             session.setAttribute("round", round);
             session.setAttribute("roundOld", roundOld);
	
//			 this.getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
			 

			 response.sendRedirect("/test/result");

		}
		
		else {
			if (round.getTotalScore() > 50) {
				round.setTotalScore(round.getTotalScore()-25);
			}
			
		
		
		dao.getRoundDao().create(round);
		
		request.setAttribute("roundOld", round); // � quoi ce truc sert ???
		
		Team team = round.getTeam();
		
		if(game.getTeam1().getName() == team.getName()) {
			team = game.getTeam2();
		}else {
			team = game.getTeam1();
		}
		
		round = dao.getRoundDao().getLastByNameAndGame(game, team);
		
			if(round == null) {
				round = new Round(team, game, 0, 0,0, 0);	
			}
		
			if(round.getScore() == 0) {
				round.setCountZero(round.getCountZero()+1);
			}else {
				round.setCountZero(0);
			}
			
			if(round.getCountZero() == 3) {
				round.setCountZero(0);
				round.setTotalScore(0);
			}
				
			round.setNbRound(round.getNbRound()+1);
			
			dao.getRoundDao().create(round);
			
//			request.setAttribute("roundOld", round); // � quoi ce truc sert ???
			
			
				
		    System.out.println("on passe ici");
			session.setAttribute("round", round);
			this.getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
		}
		
	
    }
 
}

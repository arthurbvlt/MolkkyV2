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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Team team1 = (Team) session.getAttribute("team1");
		Team team2 = (Team) session.getAttribute("team2");

		Round round = (Round) session.getAttribute("round");
		Round roundOld = (Round) session.getAttribute("roundOld");

		Game game = round.getGame();

		int score = Integer.valueOf(request.getParameter("score"));

		DaoFactory dao = DaoFactory.getInstance();

		round.setScore(score);

		Round roundLast = dao.getRoundDao().getLastByNameAndGame(game, round.getTeam());
		
		if (roundLast != null) {
			round.setTotalScore(roundLast.getTotalScore() + score);
			round.setNbRound(roundLast.getNbRound() + 1);
		} else {
			round.setTotalScore(score);
		}
		
		if (round.getTotalScore() > 50) {
			round.setTotalScore(round.getTotalScore() - 25);
		}
		
		if (round.getScore() == 0) {
			round.setCountZero(round.getCountZero() + 1);
		} else {
			round.setCountZero(0);
		}

		if (round.getCountZero() == 3) {
			round.setCountZero(0);
			round.setTotalScore(0);
		}

		dao.getRoundDao().create(round);

		session.setAttribute("roundOld", round); 
		
		if (round.getTotalScore() == 50) {
			
			
			game.setTeamWinner(round.getTeam());
			dao.getGameDao().putAWinner(game.getId(), game.getTeamWinner().getId());

			session.setAttribute("team1", team1);
			session.setAttribute("team2", team2);
			session.setAttribute("round", round);
			session.setAttribute("roundOld", roundOld);

			response.sendRedirect("/test/result");

		}

		else {

			Team team = round.getTeam();

			if (game.getTeam1().getName() == team.getName()) {
				team = game.getTeam2();
			} else {
				team = game.getTeam1();
			}

			round = dao.getRoundDao().getLastByNameAndGame(game, team);

			if (round == null) {
				round = new Round(team, game, 0, 0, 0, 0);
			}


			round.setNbRound(round.getNbRound() + 1);



			session.setAttribute("round", round);
			this.getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
		}

	}

}

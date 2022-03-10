package com.octest.servlets;

import java.io.IOException;
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


@WebServlet("/Csv")
public class Csv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Csv() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/csv.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession();

			if(!request.getParameter("select1").toString().equals(request.getParameter("select2").toString())) {
				
				DaoFactory dao = DaoFactory.getInstance();
				
		        
				Team team1 = new Team(request.getParameter("select1").toString());
				Team team2 = new Team(request.getParameter("select2").toString());
				
				Integer idTeam1 = dao.getTeamDao().getIdByName(team1.getName());
				Integer idTeam2 = dao.getTeamDao().getIdByName(team2.getName());
				
				if(idTeam1 == null) {
					dao.getTeamDao().ajouter(team1);
					 idTeam1 = dao.getTeamDao().getIdByName(team1.getName());
					team1.setId(idTeam1);
				}else {
					team1.setId(idTeam1);
				}
				
				if(idTeam2 == null) {
					dao.getTeamDao().ajouter(team2);
					idTeam2 = dao.getTeamDao().getIdByName(team2.getName());
					team2.setId(idTeam2);
				}else {
					team2.setId(idTeam2);
				}
				
				String code = generateCode(20);
				
				Game game = new Game(team1, team2, null, code);
				
				dao.getGameDao().create(game);
				
				Integer idGame = dao.getGameDao().getIdByCode(game.code);
				
				game.setId(idGame);
				
				
				
				Round roundOld = new Round(team2, game, 0, 0,1, 0);
		
				Round round = new Round(team1, game, 0, 0, 1, 0);
				
				//dao.getRoundDao().create(round);
				
				team1.setIsTurn(true);
				  	
		        session.setAttribute("team1", team1);
		        session.setAttribute("team2", team2);
		        session.setAttribute("game", game);
		        session.setAttribute("round", round);
		        
		        request.setAttribute("isSame", false);
		        session.setAttribute("roundOld", roundOld);
		        
//				this.getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
		        response.sendRedirect("/test/main");				
			}
			else {	
		        request.setAttribute("isSame", true);
				this.getServletContext().getRequestDispatcher("/WEB-INF/csv.jsp").forward(request, response);
			}
				
	}

	public String generateCode(int n)
    {
  
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }
}

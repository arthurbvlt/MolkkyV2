package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.beans.Team;


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
		
			if(!request.getParameter("select1").toString().equals(request.getParameter("select2").toString())) {
				
				Team team1 = new Team(request.getParameter("select1"));
				Team team2 = new Team(request.getParameter("select2"));
		        
				
				request.setAttribute("isSame", false);
				team1.setIsTurn(true);
				  
		        HttpSession session = request.getSession();

		        session.setAttribute("team1", team1);
		        session.setAttribute("team2", team2);
				
		        this.getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
			}
			else {	
		        request.setAttribute("isSame", true);
				this.getServletContext().getRequestDispatcher("/WEB-INF/csv.jsp").forward(request, response);
			}
			
			
		
		
		
	}

}

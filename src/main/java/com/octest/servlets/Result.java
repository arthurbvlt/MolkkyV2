package com.octest.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.beans.Team;

@WebServlet("/Result")
public class Result extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getParameter("accueil") != null) {  //appuie sur le bouton accueil
			this.getServletContext().getRequestDispatcher("/WEB-INF/teams.jsp").forward(request, response);
    	}
    }
 
}

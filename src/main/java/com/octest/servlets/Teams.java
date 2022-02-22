package com.octest.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.octest.beans.Game;
import com.octest.beans.Round;
import com.octest.beans.Team;
//import com.opencsv.CSVReader;

@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static final int TAILLE_TAMPON = 10240;
    public static String CHEMIN_FICHIERS = "";
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/teams.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomUser = System.getProperty("user.name");
		CHEMIN_FICHIERS = "C:/Users/"+ nomUser + "/Documents/"; 
		
    	HttpSession session = request.getSession();

    	System.out.println("test"); 
		if(request.getParameter("teams") != null ) {
			if( request.getParameter("team1").toString() != "" && request.getParameter("team2").toString() !="") {
				if(!request.getParameter("team1").toString().equals(request.getParameter("team2").toString())) {
					
					Team team1 = new Team(request.getParameter("team1").toString());
					Team team2 = new Team(request.getParameter("team2").toString());
					
					Game game = new Game(team1, team2, null, false);
					
					Round round = new Round(team1, game, 0, 0,1, 0);
					
					
					team1.setIsTurn(true);
					  	
			        session.setAttribute("team1", team1);
			        session.setAttribute("team2", team2);
			        session.setAttribute("game", game);
			        
			        session.setAttribute("round", round);
			        request.setAttribute("isSame", false);
			        
			        
					this.getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
				}
				else {	
			        request.setAttribute("isSame", true);
					this.getServletContext().getRequestDispatcher("/WEB-INF/teams.jsp").forward(request, response);
				}
			}
			else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/teams.jsp").forward(request, response);
			}
		}else if (request.getParameter("teams") != "Lets Play" && getNomFichier(request.getPart("file")) != "") {
			// On r�cup�re le fichier dans part
	        Part part = request.getPart("file");
	            
	        // On v�rifie qu'on a bien re�u un fichier
	        String nomFichier = getNomFichier(part);
			// Si on a bien un fichier
			if (nomFichier != null && !nomFichier.isEmpty()) {
			    String nomChamp = part.getName();
			    // Corrige un bug du fonctionnement d'Internet Explorer
			     nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
			            .substring(nomFichier.lastIndexOf('\\') + 1);
			
			    // On �crit d�finitivement le fichier sur le disque
			    ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);
			    request.setAttribute(nomChamp, nomFichier);
			}
			
		
		    	File file = new File(CHEMIN_FICHIERS + nomFichier);
				
				FileReader fileReader = new FileReader(file);
				String line = "";
				List<String> names = new ArrayList<>();
				try   
				{  
				//parsing a CSV file into BufferedReader class constructor  
				BufferedReader br = new BufferedReader(fileReader);  
				while ((line = br.readLine()) != null)   //returns a Boolean value  
				{  
				names.add(line);
				}  
				}   
				catch (IOException e)   
				{  
				e.printStackTrace();  
				}  
				
		
			session.setAttribute("names", names);
			this.getServletContext().getRequestDispatcher("/WEB-INF/csv.jsp").forward(request, response);
			   
		}
		else {
			if(getNomFichier(request.getPart("file")) == "") {
				System.out.println(getNomFichier(request.getPart("file"))+1);
			}
			this.getServletContext().getRequestDispatcher("/WEB-INF/teams.jsp").forward(request, response);
		}
	}
	
    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }
	
    private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    } 
}

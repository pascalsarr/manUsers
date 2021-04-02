package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUtilisateur;
import entities.Utilisateur;


/**
 * Servlet implementation class GestionUtilisateur
 */
@WebServlet({ "/users/add", "/users/list", "/users/update", "/users/delete" })
public class GestionUtilisateur extends HttpServlet {
	

	@EJB
	private DaoUtilisateur	dao;
	
	private static final long	serialVersionUID		= 1L;
	private static final String	VUE_AJOUT_UTILISATEUR	= "/WEB-INF/ajouterUtilisateur.jsp";
	private static final String	VUE_LIST_UTILISATEUR	= "/WEB-INF/listerUtilisateur.jsp";
	private static final String	VUE_UPDATE_UTILISATEUR	= "/WEB-INF/modifierUtilisateur.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		
		String requestedUrl = request.getServletPath();
		if (requestedUrl.equals("/users/add"))
		{
			getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR)
					.forward(request, response);
		}
		else if (requestedUrl.equals("/users/update"))
		{
			String login = request.getParameter("login");
			Utilisateur utilisateur = dao.getUserByLogin(login);
			if (utilisateur != null)
			{
				request.setAttribute("utilisateur", utilisateur);
			}
			getServletContext().getRequestDispatcher(VUE_UPDATE_UTILISATEUR)
					.forward(request, response);
		}
		else if (requestedUrl.equals("/users/delete"))
		{
			String login = request.getParameter("login");
			Utilisateur utilisateur = dao.getUserByLogin(login);
			dao.supprimer(utilisateur);
			response.sendRedirect("list");
		}
		else
		{
			request.setAttribute("utilisateurs", dao.lister());
			getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR)
			.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		
		request.setCharacterEncoding("utf-8");

		String requestedUrl = request.getServletPath();
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		Utilisateur utilisateur = new Utilisateur(nom, prenom, login,password);
		
		
		if (requestedUrl.equals("/users/add"))
		{
			
			dao.ajouter(utilisateur);
			
			response.sendRedirect(request.getContextPath());
		}
		else if (requestedUrl.equals("/users/update"))
		{
			// Utilisateur utilisateur = new Utilisateur(nom, prenom, login,
			// password);
			// DaoUtilisateur.modifier(utilisateur);
		}

		response.sendRedirect(request.getContextPath() + "/users/list");
	}

}

package servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoUtilisateur;
import entities.Utilisateur;



/**
 * Servlet implementation class Connexion
 */
@WebServlet({ "/login", "/logout" })
public class Connexion extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	private static final String	VUE_LOGIN			= "/WEB-INF/login.jsp";

	@EJB
	private DaoUtilisateur dao;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		if (request.getServletPath().equals("/login"))
		{
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request,
					response);
		}
		else
		{
			request.getSession().invalidate();
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		Utilisateur utilisateur = dao.getUserByLogin(login);
		if (utilisateur != null && utilisateur.getPassword().equals(password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", utilisateur);
			response.sendRedirect("users/list");
		}
		else
		{
			request.setAttribute("utilisateur", utilisateur);
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request,
					response);
		}
	}

}

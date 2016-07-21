package org.quinnox.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quinnox.dao.DashBoardDAO;

/**
 * Servlet implementation class ValidateLoginCredentials
 */
public class ValidateLoginCredentials extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(userName.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin")){
			response.sendRedirect("home.jsp");
		}
		else
		{
			response.sendRedirect("login.html");
		}
		
		/*DashBoardDAO dashBoardDAO = new DashBoardDAO();
		try {
			if(dashBoardDAO.checkDBConnectionCredentials(userName, password)){
				response.sendRedirect("home.jsp");
			}
			else{
				response.sendRedirect("login.html");
			}
		} catch (ClassNotFoundException e) {
			response.sendRedirect("ErrorPage.jsp");
			e.printStackTrace();
		} catch (SQLException e) {
			response.sendRedirect("ErrorPage.jsp");
			e.printStackTrace();
		}*/
	}

}

package org.quinnox.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.quinnox.dao.DashBoardDAO;

/**
 * Servlet implementation class GetFileListServlet
 */
public class GetFileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsResult = request.getParameter("frameID");
		System.out.println(jsResult);
		HttpSession session = request.getSession();
		session.setAttribute("dateTime", jsResult);
		
		DashBoardDAO dashBoardDAO = new DashBoardDAO();
		try {
			dashBoardDAO.getFileList(jsResult);
		} catch (ClassNotFoundException e) {
			response.sendRedirect("ErrorPage.jsp");
		}
		response.getWriter().write("ok");
	}

}

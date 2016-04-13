package org.quinnox.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.quinnox.dao.DashBoardDAO;
import org.quinnox.pojo.FileListBasedOnFolderName;

/**
 * Servlet implementation class GetFileListBasedOnFolderNameServlet
 */
public class GetFileListBasedOnFolderNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<FileListBasedOnFolderName> fileList;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFileListBasedOnFolderNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String jsResult = request.getParameter("frameID");
		HttpSession session = request.getSession();
		session.setAttribute("FolderName", jsResult);
		
		DashBoardDAO dashBoardDAO = new DashBoardDAO();
		try {
			fileList = dashBoardDAO.getFileListBasedOnFolderName(jsResult);
			String list = fileList.toString();
			System.out.println("LIST"+list);
			String[] lst = list.split(".xml");
			int j=1;
			for(int i = 0; i < lst.length -1 ; i++ ){
				
				//System.out.println(lst[0]);
				StringBuilder b = new StringBuilder(lst[i].replace("[", ""));
				//System.out.println(b.append(".xml"));
				
				out.println("<br>"+j+" "+b.append(".xml"));
				j++;
				
			}
			
		} catch (ClassNotFoundException e) {
			//response.sendRedirect("ErrorPage.jsp");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//response.getWriter().write("ok");
	}

}

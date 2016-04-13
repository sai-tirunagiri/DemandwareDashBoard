package org.quinnox.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.quinnox.dao.DashBoardDAO;
import org.quinnox.pojo.FolderNameList;

import com.google.gson.Gson;

/**
 * Servlet implementation class GettingFolderNamesServlet
 */
public class GettingFolderNamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GettingFolderNamesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("====INSIDE GettingFolderNamesServlet =====");
			PrintWriter out= response.getWriter();
			List<FolderNameList> folderNameLists;
		
			DashBoardDAO dashBoardDAO = new DashBoardDAO();
			Gson gson = new Gson();
			try {
				folderNameLists = dashBoardDAO.getFolderName();
				System.out.println(folderNameLists);
				JSONArray jsArray = new JSONArray(folderNameLists);
				String json = gson.toJson(jsArray);
				
				String str = json.substring(0, 15);
				//System.out.println("Substring"+str);
				
				String finalJson = json.replaceAll("\\"+str, "");
				String totalFinalJson = finalJson.replaceAll("}$", "");
				
				System.out.println("JSON"+totalFinalJson);
				out.println(totalFinalJson); 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}

	

}

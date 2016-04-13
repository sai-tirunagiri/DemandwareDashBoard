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
import org.quinnox.pojo.OverallFileCount;

import com.google.gson.Gson;

/**
 * Servlet implementation class GettingOverallCountServlet
 */
public class GettingOverallCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<OverallFileCount> overallFileCounts;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside GettingFolderWiseCountServlet");
		PrintWriter out= response.getWriter();
		DashBoardDAO dashBoardDAO = new DashBoardDAO();
		Gson gson = new Gson();
		
		
		try {
			overallFileCounts = dashBoardDAO.getOverallFileCount();
			
			JSONArray jsArray = new JSONArray(overallFileCounts);
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

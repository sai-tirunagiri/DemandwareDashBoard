package org.quinnox.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.quinnox.dao.DashBoardDAO;
import org.quinnox.pojo.GetDateAndTimeFolderWise;

import com.google.gson.Gson;

/**
 * Servlet implementation class GettingJqueryValues
 */

public class GettingJqueryValues extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String[] list = request.getParameterValues("list[]");
		//System.out.println(list[0]);
		int len = list.length;
		//System.out.println("List length"+len);
		
		DashBoardDAO dashBoardDAO = new DashBoardDAO();
		List<GetDateAndTimeFolderWise> getDateAndTimeFolderWiseList;
		Gson gson = new Gson();
		
		for(int i=0;i<len;i++){
			//System.out.println("List from for()"+list[i]);
			String folderName = list[i];
			try {
				getDateAndTimeFolderWiseList = dashBoardDAO.getDateAndTime(folderName);
				//System.out.println(list[i]+"=="+getDateAndTimeFolderWiseList);
				JSONArray jsArray = new JSONArray(getDateAndTimeFolderWiseList);
				String json = gson.toJson(jsArray);
				
				String str = json.substring(0, 15);
				//System.out.println("Substring"+str);
				
				String finalJson = json.replaceAll("\\"+str, "");
				String totalFinalJson = finalJson.replaceAll("}$", "");
				
				System.out.println("JSON"+totalFinalJson);
				out.println(list[i]+"="+totalFinalJson);
				
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}

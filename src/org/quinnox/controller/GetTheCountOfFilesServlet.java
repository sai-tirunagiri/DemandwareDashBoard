package org.quinnox.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.quinnox.dao.DashBoardDAO;
import org.quinnox.pojo.GetTimeAndFileCount;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetTheCountOfFilesServlet
 */
public class GetTheCountOfFilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startDate = request.getParameter("txtStartDate");
		String startTime = request.getParameter("txtStartTime");
		String endTime = request.getParameter("txtEndTime");
		String endDate = request.getParameter("txtEndDate");
		
		String folderName = request.getParameter("mydropdown2");
		
		String startDateAndTime = startDate+" "+startTime;
		String endDateAndTime = endDate+" "+endTime;
		
		List<GetTimeAndFileCount> timeAndFileCountList;
		DashBoardDAO dashBoardDAO = new DashBoardDAO();
		Gson gson = new Gson();
//		ServletContext servletContext = getServletContext();
		try {
			timeAndFileCountList = dashBoardDAO.getTotalCountOfRecords(startDateAndTime, endDateAndTime,folderName);
			JSONArray jsArray = new JSONArray(timeAndFileCountList);
			String json = gson.toJson(jsArray); 
			
			String str = json.substring(0, 15);
			System.out.println("Substring"+str);
			
			String finalJson = json.replaceAll("\\"+str, "");
//			String outputFolder = servletContext.getRealPath("/") + "out";
//			System.out.println(outputFolder);
//			//System.out.println(finalJson);
		//	FileWriter writer = new FileWriter("C:\\out\\myChart.json");  
			String totalFinalJson = finalJson.replaceAll("}$", "");
			
		//	writer.write(totalFinalJson);
		//	writer.close();
			request.setAttribute("Json", totalFinalJson);
			request.setAttribute("timeAndFileCountList", timeAndFileCountList);
			request.getRequestDispatcher("page2.jsp").forward(request,response);
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			response.sendRedirect("ErrorPage.jsp");
		} 
	}

}

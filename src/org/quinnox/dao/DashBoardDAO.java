package org.quinnox.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.quinnox.factory.MySqlConnectionFactory;
import org.quinnox.factory.SqlConnectionFactory;
import org.quinnox.pojo.FileListBasedOnFolderName;
import org.quinnox.pojo.FolderNameCount;
import org.quinnox.pojo.FolderNameList;
import org.quinnox.pojo.GetDateAndTimeFolderWise;
import org.quinnox.pojo.GetFileList;
import org.quinnox.pojo.GetTimeAndFileCount;
import org.quinnox.pojo.OverallFileCount;

public class DashBoardDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private String sql;
	private int count;
	private ResultSet resultSet;
	private List<GetTimeAndFileCount> timeAndFileCountList;
	private List<GetFileList> getFileLists;
	private List<FolderNameList> getFolderNameList;
	private List<GetDateAndTimeFolderWise> getDateAndTimeFolderWiseList;
	private List<FolderNameCount> folderNameCounts;
	private List<OverallFileCount> overallFileCounts;
	private List<FileListBasedOnFolderName> fileListBasedOnFolderNames;
	
	
	public boolean checkDBConnectionCredentials(String userName,String password) throws ClassNotFoundException, SQLException{
		MySqlConnectionFactory.userName = userName;
		MySqlConnectionFactory.password = password;
		connection = MySqlConnectionFactory.getConnection();
		if(connection!=null){
			return true;
		}
		return false;
	}
	
	public List<GetTimeAndFileCount> getTotalCountOfRecords(String date1,String date2,String folderName) throws ClassNotFoundException{
		try {
			connection = MySqlConnectionFactory.getConnection();
			sql = "select Date, NoOfRows from gaddevadhoc.TEST_FILE_MONITOR where Date between '"+date1+"' and '"+date2+"' and FolderName='"+folderName+"' group by Date";
			//sql = "select Date, NoOfRows from TEST_FILE_MONITOR where Date between '"+date1+"' and '"+date2+"' and FolderName='"+folderName+"' group by Date";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
		      ResultSet resultSet = preparedStatement.executeQuery();
		      timeAndFileCountList = new ArrayList<GetTimeAndFileCount>();
		      while(resultSet.next()){
		    	  GetTimeAndFileCount timeAndFileCount = new GetTimeAndFileCount();
		    	  timeAndFileCount.setTimestamp(resultSet.getTimestamp(1));
		    	  timeAndFileCount.setCount(resultSet.getInt(2));
		    	  timeAndFileCountList.add(timeAndFileCount);
		      }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
		    try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
		    try { if (connection != null) connection.close(); } catch (Exception e) {};
		}
	    return timeAndFileCountList;
	}
	
	public List<GetFileList> getFileList(String date) throws ClassNotFoundException{
		try {
			connection = MySqlConnectionFactory.getConnection();
			sql = "select FileList from gaddevadhoc.TEST_FILE_MONITOR where Date='"+date+"'";
			//sql = "select FileList from TEST_FILE_MONITOR where Date='"+date+"'";
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			getFileLists = new ArrayList<GetFileList>();
			while(resultSet.next()){
				GetFileList getFileList = new GetFileList();
				getFileList.setFileList(resultSet.getString(1));
				getFileLists.add(getFileList);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
		    try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
		    try { if (connection != null) connection.close(); } catch (Exception e) {};
		}
		return getFileLists;
	}
	public List<FolderNameList> getFolderName() throws ClassNotFoundException{
		try {
			connection = MySqlConnectionFactory.getConnection();
			sql = "select distinct FolderName from gaddevadhoc.TEST_FILE_MONITOR";
			//sql = "select distinct FolderName from TEST_FILE_MONITOR";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			getFolderNameList = new ArrayList<FolderNameList>();
			while(resultSet.next()){
				FolderNameList folderNameList = new FolderNameList();
				folderNameList.setFolderName(resultSet.getString(1));
				getFolderNameList.add(folderNameList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
		    try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
		    try { if (connection != null) connection.close(); } catch (Exception e) {};
		}
		return getFolderNameList;
	}
	
	public List<GetDateAndTimeFolderWise> getDateAndTime(String folderName) throws ClassNotFoundException{
		try {
			connection = MySqlConnectionFactory.getConnection();
			sql = "select Date , NoOfRows from gaddevadhoc.TEST_FILE_MONITOR where Date > DATE_SUB(NOW(), INTERVAL 3 HOUR) AND Date <= NOW() AND FolderName='"+folderName+"'";
		 //  sql = "select Date , NoOfRows from TEST_FILE_MONITOR where Date > DATE_SUB(NOW(), INTERVAL 24 HOUR) AND Date <= NOW() AND FolderName='"+folderName+"'";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			getDateAndTimeFolderWiseList = new ArrayList<GetDateAndTimeFolderWise>();
			while(resultSet.next()){
				GetDateAndTimeFolderWise getDateAndTimeFolderWise = new GetDateAndTimeFolderWise();
				getDateAndTimeFolderWise.setTimestamp(resultSet.getTimestamp(1));
				getDateAndTimeFolderWise.setCount(resultSet.getInt(2));
				getDateAndTimeFolderWiseList.add(getDateAndTimeFolderWise);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
		    try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
		    try { if (connection != null) connection.close(); } catch (Exception e) {};
		}
		return getDateAndTimeFolderWiseList;
	}
	
	public List<FolderNameCount> getFolderNameCount() throws ClassNotFoundException{
		try {
			connection = MySqlConnectionFactory.getConnection();
			//sql = "select Date , NoOfRows from test.TEST_FILE_MONITOR where Date > DATE_SUB(NOW(), INTERVAL 3 HOUR) AND Date <= NOW() AND FolderName='"+folderName+"'";
		    sql = "SELECT FolderName,SUM(NoOfRows) as NoOfFiles FROM gaddevadhoc.TEST_FILE_MONITOR WHERE Date > DATE_SUB(NOW(), INTERVAL 1 HOUR) AND Date <= NOW() GROUP BY FolderName";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			folderNameCounts = new ArrayList<FolderNameCount>();
			while(resultSet.next()){
				FolderNameCount folderNameCount = new FolderNameCount();
				folderNameCount.setFolderName(resultSet.getString(1));
				folderNameCount.setFileCount(resultSet.getInt(2));
				folderNameCounts.add(folderNameCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
		    try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
		    try { if (connection != null) connection.close(); } catch (Exception e) {};
		}
		return folderNameCounts;
	}
	
	
	public List<OverallFileCount> getOverallFileCount() throws ClassNotFoundException{
		try {
			connection = MySqlConnectionFactory.getConnection();
			sql = "select DATE_FORMAT(TEST_FILE_MONITOR.Date,'%d-%m-%y') as dateFormat,SUM(TEST_FILE_MONITOR.NoOfRows) as NoOfFiles from gaddevadhoc.TEST_FILE_MONITOR where Date > DATE_SUB(NOW(), INTERVAL 7 Day) AND Date <= NOW() GROUP BY Date(TEST_FILE_MONITOR.Date)";
			
			//sql = "select Date , NoOfRows from test.TEST_FILE_MONITOR where Date > DATE_SUB(NOW(), INTERVAL 3 HOUR) AND Date <= NOW() AND FolderName='"+folderName+"'";
		    //sql = "select HOUR(TEST_FILE_MONITOR.Date),SUM(TEST_FILE_MONITOR.NoOfRows) as NoOfFiles from test.TEST_FILE_MONITOR where DATE(TEST_FILE_MONITOR.Date)=DATE(NOW()) GROUP BY HOUR(TEST_FILE_MONITOR.Date)";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			overallFileCounts = new ArrayList<OverallFileCount>();
			while(resultSet.next()){
				OverallFileCount overallFileCount = new OverallFileCount();
				overallFileCount.setTimestamp(resultSet.getString(1));
				overallFileCount.setCount(resultSet.getInt(2));
				overallFileCounts.add(overallFileCount);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
		    try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
		    try { if (connection != null) connection.close(); } catch (Exception e) {};
		}
		return overallFileCounts;
	}
	
	public List<FileListBasedOnFolderName> getFileListBasedOnFolderName(String folderName) throws ClassNotFoundException {
		try{
			connection = MySqlConnectionFactory.getConnection();
			sql = "select FileList from gaddevadhoc.TEST_FILE_MONITOR where FolderName='"+folderName+"'";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			fileListBasedOnFolderNames = new ArrayList<FileListBasedOnFolderName>();
			while(resultSet.next()){
				FileListBasedOnFolderName basedOnFolderName = new FileListBasedOnFolderName();
				basedOnFolderName.setFileList(resultSet.getString(1));
				fileListBasedOnFolderNames.add(basedOnFolderName);
			}
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {
			    try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
			    try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
			    try { if (connection != null) connection.close(); } catch (Exception e) {};
			}
		return fileListBasedOnFolderNames;
			
	}
	
}

package org.quinnox.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnectionFactory {
	private static Connection connection;
	public static String hostName;
	public static String userName;
	public static String password;

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Driver loaded successfully!");
		connection = DriverManager.getConnection("jdbc:sqlserver://"+hostName+";DatabaseName=Test_File_Moniter",userName,password);
		if(connection!=null){
			return connection;
		}
		else
		{
			return null;
		}
		
	}
}

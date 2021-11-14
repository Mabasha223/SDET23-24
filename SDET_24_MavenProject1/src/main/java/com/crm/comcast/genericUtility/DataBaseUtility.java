package com.crm.comcast.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

/**
 * 
 * @author mabasha
 *
 */

public class DataBaseUtility {
	static Driver driver;
	static Connection connection;
	static ResultSet result;
	
	/**
	 * this method will perform the database connection
	 */
	
	public void ConnectDataBase()
	{
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method will perform the database close
	 * @throws Throwable 
	 */
	public void CloseDataBase() throws Throwable 
	{
		connection.close();
		
	}
	public ResultSet excuteQuery(String Query)
	{
		try 
		{
			result=connection.createStatement().executeQuery(Query);
			return  result;
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return  result;
		
	}
}

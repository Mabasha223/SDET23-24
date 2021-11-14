package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleNonSelectQuery_try_catch_finallyBlock 
{

	public static void main(String[] args) throws SQLException 
	{
		Connection con=null;
		try
		{
			// Step-1: load/register the driver for specific database
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
		
			// Step-2: connect to db
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		
			// Step-3: create/issue sql statement
			Statement stat = con.createStatement();
		
			// Step-4: execute the query
			int result = stat.executeUpdate("insert into student values(7, 'ram', 'gowda', 'ramgowda@gmail.com')");
			if(result==1)
			{
				System.out.println("Student Created--!");
			}
		}
		catch (Exception e) 
		{
			System.err.println("Student not Created--!");
		}
		finally 
		{
			// Step-5: close the connection
			con.close();
			System.out.println("===================closed connection===============");
			
		}
		
		

	}

}

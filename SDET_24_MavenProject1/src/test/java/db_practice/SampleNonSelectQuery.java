package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleNonSelectQuery 
{

	public static void main(String[] args) throws SQLException 
	{
		
		// Step-1: load/register the driver for specific database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		// Step-2: connect to db
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		
		// Step-3: create/issue sql statement
		Statement stat = con.createStatement();
		
		// Step-4: execute the query
		int result = stat.executeUpdate("insert into student values(7, 'ram', 'gowda', 'ramgowda@gmail.com')");
		if(result==1)
		{
			System.out.println("Student Created--!");
		}
		else
		{
			System.out.println("Student not created");
		}
		
		// Verify
		// Step-5: close the connection
		con.close();

	}

}

package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleSelectQuery 
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
		ResultSet set = stat.executeQuery("select * from student");
		while(set.next())
		{
			System.out.println(set.getInt(1) + "\t" + set.getString(2) + "\t" + set.getString(3) + "\t" + set.getString(4));
		}
		
		// Verify
		// Step-5: close the connection
		con.close();

	}

}

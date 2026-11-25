package com.comcast.crm.generic.databaseutility;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;


public class DataBaseUtility {
	//Get connection
	Connection con;
public void getDbconnection(String url, String username, String password) throws SQLException
{
	try {
Driver driver=new Driver();
DriverManager.registerDriver(driver);
DriverManager.getConnection(url,username,password);
	}catch(Exception e){	
	}
}

public void getDBconnection()
{
	try
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("");
	}
	catch(Exception e)
	{
		
	}
}
	
	//Close connection
	public void closeDBconnection() throws SQLException
	{
		try {
	    con.close();
		}catch(Exception e){	
		}
	}
	
	public ResultSet executeConSelectQuery(String query) throws SQLException
	{
		ResultSet result=null;
		try{
		Statement stat=con.createStatement();
		 result=stat.executeQuery(query);
		}
		catch(Exception e) {
		}
		return result;
		}
	
	public int executeNonselectQuery(String query)
	{
		int result=0;
		try
		{
			Statement stat=con.createStatement();
			result=stat.executeUpdate(query);
		}catch(Exception e){
	}
		return result;
	}
	


}
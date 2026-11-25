package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDB {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
Driver d=new Driver();

DriverManager.registerDriver(d);

Connection con = DriverManager.getConnection(
	    "jdbc:mysql://49.249.29.4:3307/ninza_hrm",
	    "root@%",
	    "root"
	);

Statement stat=con.createStatement();

ResultSet project=stat.executeQuery("select* from project");
while(project.next()) {
	System.out.println("PID:"+project.getString(1)+"X");
}
	}

}

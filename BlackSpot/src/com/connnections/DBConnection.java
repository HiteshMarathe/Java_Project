package com.connnections;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection connect()
	{
		Connection con=null;
		try {
	
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blackspot","root","");
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return(con);
		
	}


}

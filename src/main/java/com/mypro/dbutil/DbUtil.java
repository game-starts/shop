package com.mypro.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {
	private static Connection cn;
	

	public static Connection getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql:///shop";
			cn = DriverManager.getConnection(url, "root", "sxx123");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
	

	public static void closeConn(){
		if(cn!=null){
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

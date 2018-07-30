package com.zzh.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
public class DBConnection {
	static String URL="jdbc:mysql://localhost:3306/douban?characterEncoding=utf-8";
    static String USER="root";
    static String PASSWORD="root";
    static{
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static Connection getConnection() throws SQLException{
    	return DriverManager.getConnection(URL,USER,PASSWORD);
          
    }
    public static void close(Connection conn, Statement stat, ResultSet rs)
	{
		
		try {
			if (rs != null)
			{
				rs.close();
			}
			if (stat != null)
			{
				stat.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stat)
	{
		close(conn,stat,null);
	}

	
}
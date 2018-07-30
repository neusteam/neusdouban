package com.zzh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zzh.bean.UserEntity;
import com.zzh.dao.UserEntityDAO;
import com.zzh.util.DBConnection;

public class UserEntityDAOImpl implements UserEntityDAO{
	

	@Override
	public boolean login(UserEntity ue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(UserEntity ue) {
		// TODO Auto-generated method stub
			  Statement sta=null;
			  Connection conn=null;
			  try {
				conn=DBConnection.getConnection();
				  sta=conn.createStatement();
				  String sql="insert into users (username,password) values ('"+ue.getUserName()+"','"+ue.getPassWord()+"')";
				  System.out.println(sql);
				  int count=sta.executeUpdate(sql);
				  if(count!=0)return true;
				  else return false;
				  	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			finally{
				DBConnection.close(conn, sta);
			}
	}

	@Override
	public boolean addinfo(UserEntity ue) {
		  Statement sta=null;
		  Connection conn=null;
		  try {
			conn=DBConnection.getConnection();
			sta=conn.createStatement();
			String sql="update users set rname ='"+ue.getName()+"',sex ='"+ue.getSex()+"',url ='"+ue.getUrl()+"',phonenumber ='"+ue.getPhoneNumber()+"',email ='"+ue.getEmail()+"',city ='"+ue.getCity()+"',birth ='"+ue.getBirth()+"' where username='"+ue.getUserName()+"'";
			System.out.println(sql);
			int count=sta.executeUpdate(sql);
			 if(count!=0)return true;
			  else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		  finally{
				DBConnection.close(conn, sta);
			}
		  
		// TODO Auto-generated method stub
		
	}
	public boolean updatename(UserEntity ue){
		  Statement sta=null;
		  Connection conn=null;
		  try {
			conn=DBConnection.getConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean finduser(UserEntity ue){
		Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
		
		try {
			conn=DBConnection.getConnection();
			sta=conn.createStatement();
			String sql=("select username,password,status from users where username='"+ue.getUserName()+"' and password='"+ue.getPassWord()+"'");
			rs=sta.executeQuery(sql);
			int count=0;
	        int flag=0;
	      
			while(rs.next()){
			count++;
		     flag=rs.getInt("status");
		   
			}
			if(count!=0&&flag==1)return true;
			else return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
			DBConnection.close(conn, sta);
		}
		
		
	}
	
 public boolean regcheck(UserEntity ue){
	 
	 Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
		
		try {
			conn=DBConnection.getConnection();
			sta=conn.createStatement();
			String sql=("select username,password from users where username='"+ue.getUserName()+"'");
			rs=sta.executeQuery(sql);
			int count=0;
	       
	      
			while(rs.next()){
			count++;
		  
		   
			}
			if(count!=0)return true;
			else return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
			DBConnection.close(conn, sta);
		}
		
		
 }
 public boolean findadmin(UserEntity ue){
	 Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
		
		try {
			conn=DBConnection.getConnection();
			sta=conn.createStatement();
			String sql=("select username,password,status from users where username='"+ue.getUserName()+"' and password='"+ue.getPassWord()+"'");
			rs=sta.executeQuery(sql);
			int count=0;
	        int flag=0;
	      
			while(rs.next()){
			count++;
		     flag=rs.getInt("status");
		  
		   
			}
			if(count!=0&&flag==2)return true;
			else return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		finally{
			DBConnection.close(conn, sta,rs);
		}
 }
}

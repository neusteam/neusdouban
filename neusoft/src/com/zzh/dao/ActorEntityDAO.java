package com.zzh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.zzh.bean.ActorEntity;
import com.zzh.bean.UserEntity;
import com.zzh.util.DBConnection;

public class ActorEntityDAO {
	public boolean addActor(ActorEntity ae) {
		  Statement sta=null;
		  Connection conn=null;
		  try {
			conn=DBConnection.getConnection();
			sta=conn.createStatement();
			String sql="insert into actorinfo (name,sex,birth,hometown,occupation,decribe,url) values ('"+ae.getName()+"','"+ae.getSex()+"','"+ae.getBirth()+"','"+ae.getHometown()+"','"+ae.getOccupation()+"','"+ae.getUrl()+"')";
			System.out.println(sql);
			int count=sta.executeUpdate(sql);
			 if(count!=0)return true;
			  else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		  
		// TODO Auto-generated method stub
		
	}
	public boolean deleteActor(ActorEntity ae){
		Statement sta=null;
		Connection conn=null;
		try {
			conn=DBConnection.getConnection();
			sta=conn.createStatement();
			String sql = "delete from actorinfo where id = '"+ae.getId()+"'";
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
	public boolean updateActorinfo(ActorEntity ae){
		Statement sta = null;
		Connection conn = null;
		try
		{
		conn = DBConnection.getConnection();
		sta=conn.createStatement();
		String sql = "update actorinfo set occupation ='"+ae.getOccupation()+"',describe ='"+ae.getDescribe()+"',url ='"+ae.getUrl()+"' where id='"+ae.getId()+"'";
	     int count=sta.executeUpdate(sql);
	     if(count!=0)return true;
	     else return false;
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
		}finally{
		DBConnection.close(conn, sta);
		}
		
		
	}
}

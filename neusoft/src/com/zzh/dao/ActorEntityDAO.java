package com.zzh.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zzh.bean.ActorEntity;

import com.zzh.util.DBConnection;

public class ActorEntityDAO {
	public boolean addActor(ActorEntity ae) {
		  Statement sta=null;
		  Connection conn=null;
		  try {
			conn=DBConnection.getConnection();
			sta=conn.createStatement();
			String sql="insert into actorinfo (actorname,sex,birth,hometown,occupation,actordescribe,url) values ('"+ae.getName()+"','"+ae.getSex()+"','"+ae.getBirth()+"','"+ae.getHometown()+"','"+ae.getOccupation()+"','"+ae.getDescribe()+"','"+ae.getUrl()+"')";
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
		String sql = "update actorinfo set occupation ='"+ae.getOccupation()+"',actordescribe ='"+ae.getDescribe()+"',url ='"+ae.getUrl()+"' where id='"+ae.getId()+"'";
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
	public ArrayList<ActorEntity> getActorList(ActorEntity ae)
	{
		
			ArrayList<ActorEntity> actorlist = new ArrayList<ActorEntity>();  
			Statement sta = null;
			Connection conn = null;
			ResultSet rs = null;
	        try {
				conn = DBConnection.getConnection();  
		        sta = conn.createStatement();  		        
		        String sql = "select * from actorinfo where actorname='"+ae.getName()+"'";
		        System.out.println(sql);
		        rs = sta.executeQuery(sql); 		      
		        while (rs.next()){ 
		        	

		        	int id=rs.getInt("id");
		        	String actorname=rs.getString("actorname");
		            String sex=rs.getString("sex"); 
		            String birth=rs.getString("birth"); 
		            String hometown=rs.getString("hometown"); 
		            String occupation=rs.getString("occupation"); 
		            String describe=rs.getString("actordescribe"); 
		            String url=rs.getString("url"); 
		            ActorEntity actor=new ActorEntity(id,actorname,sex,birth,hometown,occupation,describe,url);
		            actorlist.add(actor);
		            System.out.println("ÐÅÏ¢Îª£º"+actorlist);
		        
		        }  
			} 
	        catch (SQLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}  finally
			{
				DBConnection.close(conn, sta);
			}
	        return actorlist;
		}

}

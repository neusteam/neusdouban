package com.zzh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.zzh.bean.CommentEntity;
import com.zzh.util.DBConnection;

public class CommentEntityDAO {
public boolean AddComment(CommentEntity ce){
	  Statement sta=null;
	  Connection conn=null;
	  try {
		conn=DBConnection.getConnection();
		sta=conn.createStatement();
		String sql="insert into scores (score,comments,user_id,movie_id,date) values ('"+ce.getScore()+"','"+ce.getComments()+"','"+ce.getUser_id()+"','"+ce.getMovie_id()+"','"+ce.getDate()+"')";
		System.out.println(sql);
		int count=sta.executeUpdate(sql);
		 if(count!=0)return true;
		  else return false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
}

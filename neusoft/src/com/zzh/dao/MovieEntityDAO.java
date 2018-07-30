package com.zzh.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zzh.bean.ActorEntity;
import com.zzh.bean.MovieEntity;
import com.zzh.util.DBConnection;

public class MovieEntityDAO {
	public ArrayList<MovieEntity> getMovieList(MovieEntity me)
	{
		
			ArrayList<MovieEntity> movielist = new ArrayList<MovieEntity>();  
			Statement sta = null;
			Connection conn = null;
			ResultSet rs = null;
	        try {
				conn = DBConnection.getConnection();  
		        sta = conn.createStatement();  		        
		        String sql = "select * from movieinfo where moviename='"+me.getMovieName()+"'";
		        System.out.println(sql);
		        rs = sta.executeQuery(sql); 		      
		        while (rs.next()){ 
		        	

		        	int id=rs.getInt("movie_id");
		        	String moviename=rs.getString("moviename");
		            String date=rs.getString("date"); 
		            String director=rs.getString("director"); 
		            String actor=rs.getString("actor"); 
		            String type=rs.getString("type"); 
		            String country=rs.getString("country"); 
		            String language=rs.getString("language"); 
		            String picture=rs.getString("picture");
		            float average=rs.getFloat("average");
		            String describe=rs.getString("moviedescribe");
		            MovieEntity movie=new MovieEntity(id,moviename,date,director,actor,type,country,language,picture,average,describe);
		            movielist.add(movie);
		            System.out.println("��ϢΪ��"+movielist);
		        
		        }  
			} 
	        catch (SQLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}  finally
			{
				DBConnection.close(conn, sta);
			}
	        return movielist;
		}

	public static void main(String[] args) {
		MovieEntity me=new MovieEntity();
		me.setMovieName("�Ҳ���ҩ��");
		ArrayList<MovieEntity> movielist = new ArrayList<MovieEntity>();
		MovieEntityDAO m=new MovieEntityDAO();
		movielist=m.getMovieList(me);
		System.out.println("��Ϣ3"+movielist);
	}
}

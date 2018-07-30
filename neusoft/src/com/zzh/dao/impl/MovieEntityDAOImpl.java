package com.zzh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zzh.bean.MovieEntity;
import com.zzh.dao.MovieEntityDAO;
import com.zzh.util.DBConnection;

public class MovieEntityDAOImpl implements MovieEntityDAO {

	public boolean addMovie(MovieEntity me) {
		Connection conn = null;
		Statement sta = null;
		boolean flag = false;

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "insert into movieinfo values(null,'" + me.getMovieName() + "','" + me.getDate() + "','"
					+ me.getDirector() + "','" + me.getActor() + "','" + me.getType() + "','" + me.getCountry() + "','"
					+ me.getLanguage() + "','" + me.getPicture() + "','" + me.getAverage() + "','" + me.getDescribe()
					+ "');";
			System.out.println("sql:" + sql);
			int rs = sta.executeUpdate(sql);
			if (rs != 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				flag = false;
			}
		}

		return flag;

	}

	public boolean altMovie(MovieEntity me) {
		Connection conn = null;
		Statement sta = null;
		boolean flag = false;

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();

			int movie_id = me.getMovie_id();
			String moviename = me.getMovieName();
			String date = me.getDate();
			String director = me.getDirector();
			String actor = me.getActor();
			String type = me.getType();
			String country = me.getCountry();
			String language = me.getLanguage();
			double average = me.getAverage();
			String describe = me.getDescribe();

			// movie_id, moviename, date, director, actor, type, country,
			// language, average, describe
			String sql = "update douban.movieinfo set 'moviename='" + moviename + "',date='" + date + "',director='"
					+ director + "',actor='" + actor + "',type='" + type + "',country='" + country + "',language='"
					+ language + "',average'" + average + "',describe='" + describe + "'where movie_id='" + movie_id
					+ "';";
			
			int rs = sta.executeUpdate(sql);
			if (rs != 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				flag = false;
			}
		}
		return flag;
	}
	public ArrayList<MovieEntity> selectMovieList(String mname)
	{
		
			ArrayList<MovieEntity> movielist = new ArrayList<MovieEntity>();  
			Statement sta = null;
			Connection conn = null;
			ResultSet rs = null;
	        try {
				conn = DBConnection.getConnection();  
		        sta = conn.createStatement();  		        
		        String sql = "select * from movieinfo where moviename='"+mname+"'";
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
		           
		        
		        }  
		        System.out.println("信息为:"+movielist);
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
	public ArrayList<MovieEntity> getMovieList(int count)
	{
		
			ArrayList<MovieEntity> movielist = new ArrayList<MovieEntity>();  
			Statement sta = null;
			Connection conn = null;
			ResultSet rs = null;
	        try {
				conn = DBConnection.getConnection();  
		        sta = conn.createStatement();  		        
		        int m= 0;
		        int n= m + count;
		        String sql = "select * from movieinfo limit "+m+","+n+"";
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
		           
		        
		        }  
		        System.out.println("信息为:"+movielist);
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
		
		ArrayList<MovieEntity> movielist = new ArrayList<MovieEntity>();
		MovieEntityDAOImpl m=new MovieEntityDAOImpl();
		MovieEntity me=new MovieEntity();
		String mname="我不是药神";
		movielist=m.selectMovieList(mname);
		System.out.println("信息3"+movielist);
	}
}

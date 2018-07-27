package com.zzh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zzh.bean.ArticleEntity;
import com.zzh.bean.MovieEntity;
import com.zzh.dao.ArticleEntityDAO;
import com.zzh.util.DBConnection;

public class ArticleEntityDAOImpl implements ArticleEntityDAO {

	
	public boolean addArticle(ArticleEntity ae) {
		Connection conn = null;
		Statement sta = null;
		boolean flag = false;
		
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			System.out.println("ae.getContent():"+ae.getContent());
			String sql = "insert into articles values(null,'"+ae.getContent()+"','"+ae.getAuthorId()+"','"+ae.getMovieId()+"','"+ae.getDate()+"');";
			int rs = sta.executeUpdate(sql);
			if(rs!=0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		}
		
		return flag;
		
		
	}


	public MovieEntity fndMovieByArticleId(ArticleEntity ae) {
		Connection conn = null;
		Statement sta = null;
		MovieEntity me = new MovieEntity();
		
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			//select * from movieinfo where movie_id=(select movie_id from articles where id =3);
			String sql = "select movieinfo where movie_id=(select movie_id from articles where id='"+ae.getArticleId()+"');";
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()){
				int movieId = rs.getInt("movie_id");
				String movieName = rs.getString("movie_name");
				String date = rs.getString("date");
				String director = rs.getString("director");
				String actor = rs.getString("actor");
				String type = rs.getString("type");
				String country = rs.getString("country");
				String language = rs.getString("language");
				String picture = rs.getString("picture");
				double average = rs.getDouble("average");
				String describe = rs.getString("describe");
				me.setActor(actor);
				me.setAverage(average);
				me.setCountry(country);
				me.setDate(date);
				me.setDescribe(describe);
				me.setDirector(director);
				me.setLanguage(language);
				me.setMovieId(movieId);
				me.setMovieName(movieName);
				me.setPicture(picture);
				me.setType(type);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			return me;
		
			
		
	}
	
	public boolean altArticle(ArticleEntity ae) {
		Connection conn = null;
		Statement sta = null;
		boolean flag = false;
		
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

	public boolean delArticle(ArticleEntity ae) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

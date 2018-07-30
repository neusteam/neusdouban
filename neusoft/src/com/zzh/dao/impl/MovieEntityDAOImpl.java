package com.zzh.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

			int movie_id = me.getMovieId();
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

}

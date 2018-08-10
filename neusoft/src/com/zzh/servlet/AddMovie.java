package com.zzh.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.zzh.bean.MovieEntity;
import com.zzh.dao.MovieEntityDAO;
import com.zzh.dao.impl.MovieEntityDAOImpl;

/**
 * Servlet implementation class AddMovie
 */
@WebServlet("/AddMovie")
public class AddMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovie() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public String readJSONString(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return json.toString();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("application/json");
		request.setCharacterEncoding("UTF-8");
		String json = readJSONString(request);
		JSONObject jo = JSONObject.parseObject(json);
		MovieEntity me = new MovieEntity();
		me.setMovieId(jo.getInteger("movie_id"));
		me.setMovieName(jo.getString("moviename"));
		me.setActor(jo.getString("actor"));
		me.setDirector(jo.getString("director"));
		me.setCountry(jo.getString("country"));
		me.setAverage(jo.getDouble("average"));
		me.setLanguage(jo.getString("language"));
		me.setDescribe(jo.getString("describe"));
		me.setPicture(jo.getString("picture"));
		me.setType(jo.getString("type"));
		me.setDate(jo.getString("date"));
		
		MovieEntityDAO dao = new MovieEntityDAOImpl();
		boolean flag = dao.addMovie(me);
		
		if (flag) {
			request.setAttribute("message", "success");
		} else {
			request.setAttribute("message", "fail");
		}
		
	}

}

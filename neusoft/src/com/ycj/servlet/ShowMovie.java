package com.ycj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ycj.pojo.DataPackage;
import com.zzh.bean.MovieEntity;

import com.zzh.dao.impl.MovieEntityDAOImpl;
import com.zzh.util.JsonDecoding;
@WebServlet("/ShowMovie")
public class ShowMovie extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ShowMovie() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String json = JsonDecoding.readJSONString(request);
		System.out.println(json);
		JSONObject jo = JSONObject.parseObject(json);
		int count = Integer.parseInt(jo.getString("count"));

		ArrayList<MovieEntity> movielist = new ArrayList<MovieEntity>();
		MovieEntityDAOImpl m=new MovieEntityDAOImpl();
		movielist=m.getMovieList(count);
//		System.out.println("пео╒"+movielist);
		DataPackage pac = new DataPackage();
		pac.setErrorCode("10000");
		pac.setErrorMsg("success");
		pac.setData(movielist.toString());
		System.out.println("data:" + pac.toString());
		response.getWriter().write(pac.toString());

		out.flush();
		out.close();
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}

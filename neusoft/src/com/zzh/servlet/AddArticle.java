package com.zzh.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zzh.bean.ArticleEntity;
import com.zzh.dao.ArticleEntityDAO;
import com.zzh.dao.impl.ArticleEntityDAOImpl;
import com.zzh.util.Time;

import com.alibaba.fastjson.*;

/**
 * Servlet implementation class AddArticle
 */
@WebServlet("/AddArticle")
public class AddArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		response.setContentType("application/json");
		BufferedReader reader = request.getReader();
        String json = reader.readLine();
        System.out.println(json);
        reader.close();
        JSONObject jo = JSONObject.parseObject(json);
   
        System.out.println("content:"+jo.getString("content"));
		ArticleEntity ae = new ArticleEntity();
		
		
		
		
//			jo.put("id", "4");
//			jo.put("content", "abcdefghijklmn");
//			jo.put("authorId", "12");
//			jo.put("movieId", "1234");
//			
////			-----------------------------------
//			
//			jo.getString("content");
			
//			String authorId = request.getParameter("authorId");
//			String content = request.getParameter("content");
//			String id = request.getParameter("id");
//			String movieId = request.getParameter("movieId");
//			ae.setArticleId(ja.getString(0));
//			ae.setContent(ja.getString(1));
//			ae.setAuthorId(ja.getString(2));
//			ae.setDate(new Date());
//			ae.setMovieId(ja.getString(3));
//		

		
		ArticleEntityDAO articleEntityDAO = new ArticleEntityDAOImpl();
		boolean flag = articleEntityDAO.addArticle(ae);
		if(flag){
			request.setAttribute("message", "success");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "success");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		}
		
		
	}

}

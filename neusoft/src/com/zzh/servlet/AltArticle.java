package com.zzh.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.zzh.bean.ArticleEntity;
import com.zzh.dao.ArticleEntityDAO;
import com.zzh.dao.impl.ArticleEntityDAOImpl;

/**
 * Servlet implementation class AltArticle
 */
@WebServlet("/AltArticle")
public class AltArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltArticle() {
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
		
		System.out.println("content:" + jo.getString("content"));
		ArticleEntity ae = new ArticleEntity();
		ae.setArticleId(jo.getString("id"));
		ae.setContent(jo.getString("content"));
		ae.setAuthorId(jo.getString("authorId"));
		ae.setMovieId(jo.getString("movieId"));
		
		ArticleEntityDAO articleEntityDAO = new ArticleEntityDAOImpl();
		boolean flag = articleEntityDAO.altArticle(ae);
		
		if (flag) {
			request.setAttribute("message", "success");
		} else {
			request.setAttribute("message", "fail");
		}
	}

}

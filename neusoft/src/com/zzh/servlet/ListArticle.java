package com.zzh.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class ListArticle
 */
@WebServlet("/ListArticle")
public class ListArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListArticle() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("application/json");
		request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

		
		ArticleEntityDAO articleEntityDAO = new ArticleEntityDAOImpl();
		ArrayList<ArticleEntity> aeList = articleEntityDAO.listArticle();
		ArticleEntity ae = new ArticleEntity();
		
		out.write(ae.parseJson(aeList));
//		System.out.println(ae.parseJson(aeList));
		out.flush();
		
//		List<Province> provinces=provinceDao.getProvinces();
//        getJson(request, response, provinces);
		
		
		
	}

}

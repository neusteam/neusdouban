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
 * Servlet implementation class VerifyArticle
 */
@WebServlet("/VerifyArticle")
public class VerifyArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyArticle() {
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
		String json = readJSONString(request);
		JSONObject jo = JSONObject.parseObject(json);
		int articleId = jo.getInteger("id");
		int isPass = jo.getInteger("verify");
		
        ArticleEntityDAO articleEntityDAO = new ArticleEntityDAOImpl();
		boolean flag = articleEntityDAO.verifyArticle(articleId,isPass);
		
		if (flag) {
			request.setAttribute("message", "success");
		} else {
			request.setAttribute("message", "fail");
		}
	
	}

}

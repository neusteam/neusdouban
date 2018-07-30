package com.ycj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzh.bean.CommentEntity;
import com.zzh.dao.CommentEntityDAO;
@WebServlet("/CommentAdd")
public class CommentAdd extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public CommentAdd() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		    String name =request.getParameter("rname");
		    Float score=Float.parseFloat(request.getParameter("score"));
		    String comment=request.getParameter("comment");
		    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date currentTime = new Date();
		    String date=s.format(currentTime);
		    CommentEntity ce=new CommentEntity();
		    ce.setScore(score);
		    ce.setComments(comment);
		    ce.setDate(date);
		    CommentEntityDAO c=new CommentEntityDAO();
		    c.AddComment(ce);
		    
		    
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

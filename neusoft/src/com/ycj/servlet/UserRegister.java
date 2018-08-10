package com.ycj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzh.bean.UserEntity;
import com.zzh.dao.impl.UserEntityDAOImpl;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	public UserRegister() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserEntity user=new UserEntity();
        user.setUserName(username);
        user.setPassWord(password);
        UserEntityDAOImpl u = new UserEntityDAOImpl();
        boolean f=u.regcheck(user);
        if(f){
        	out.println("<script>alert('用户已存在');history.back()</script>");
        }
        else {
        	u.register(user);
        	Cookie cookie=new Cookie("username",username);
        	cookie.setMaxAge(30);
        	cookie.setPath("/");
        	response.addCookie(cookie);
        	out.println("<script>alert('登录成功')</script>");
        	response.sendRedirect("static/index.html");
        	}
        
        //request.getRequestDispatcher("LoginS.html").forward(request, response);
        
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}

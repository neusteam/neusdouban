package com.ycj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzh.bean.UserEntity;
import com.zzh.dao.impl.UserEntityDAOImpl;

@WebServlet("/Register")
public class Register extends HttpServlet {
	public Register() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserEntity user=new UserEntity();
        user.setUserName(username);
        user.setPassWord(password);
        UserEntityDAOImpl u = new UserEntityDAOImpl();
        boolean f=u.regcheck(user);
        if(f){
        	System.out.println("用户已存在！！");
        }
        else {
        	u.register(user);
        	}
        
        //request.getRequestDispatcher("LoginS.html").forward(request, response);
        
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}

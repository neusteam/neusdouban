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
@WebServlet("/UserAddinfo")
public class UserAddinfo extends HttpServlet {

	
	public UserAddinfo() {
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
		request.setCharacterEncoding("UTF-8");
	    String name =request.getParameter("rname");
	    String sex=request.getParameter("sex");
	    String url=request.getParameter("url");
	    String pn=request.getParameter("phonenumber");
	    String email=request.getParameter("email");
	    String city=request.getParameter("city");
	    String birth=request.getParameter("birth");
	    Cookie cookie[]=request.getCookies();
	    if(cookie==null||cookie.length==0){
	    	
	    }
	    else{
	    	for(Cookie cookies:cookie){
	    		String value =cookies.getValue();
	    		 UserEntity user=new UserEntity();
	    		user.setUserName(value);
	    		user.setName(name);
		 	    user.setSex(sex);
		 	    user.setUrl(url);
		 	    user.setPhoneNumber(pn);
		 	    user.setEmail(email);
		 	    user.setCity(city);
		 	    user.setBirth(birth);
		 	    UserEntityDAOImpl u = new UserEntityDAOImpl();
		 	    u.addinfo(user);
	    		 }
	    	
	 	   
	 	    
	    }
	   
	    
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

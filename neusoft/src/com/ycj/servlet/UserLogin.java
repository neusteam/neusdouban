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
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public UserLogin() {
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


	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");

	    UserEntity user=new UserEntity();
        user.setUserName(username);
        user.setPassWord(password);
        UserEntityDAOImpl u = new UserEntityDAOImpl();
     
         boolean flag=u.finduser(user);
        if(flag){
        	
        	System.out.println("��½�ɹ�");
        	int id=u.findid(user);
        	
        	Cookie cookie=new Cookie("username",username);
        	cookie.setMaxAge(3000);
        	cookie.setPath("/");
        	response.addCookie(cookie);
        	Cookie cookie1=new Cookie("id",String.valueOf(id));
        	response.addCookie(cookie1);
        	response.sendRedirect("static/index.html");
         
           
            
        	
        }
        else{
        	out.println("<script>alert('�˺������������');history.back()</script>");
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

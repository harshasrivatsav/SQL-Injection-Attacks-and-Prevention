package com.harsha.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.dao.LoginDao;


public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
		String n=request.getParameter("username");  
		String p=request.getParameter("password"); 
		
		HttpSession session = request.getSession(true);
		if(session!=null)
		session.setAttribute("name", n);
		String output = LoginDao.validate(n, p);
		if(output.contentEquals("true")){  
			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");  
			rd.forward(request,response);  
		}  
		else if(output.contentEquals("false")){   
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
			out.print("<center><h2 style=\"color:black\">Sorry username or password doesnot match</h2></center>"); 
			rd.include(request,response);  
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
			out.print("<center><h2 style=\"color:black\">"+output+"</h2></center>"); 
			rd.include(request,response);
		}

		out.close();  
	}  
}  


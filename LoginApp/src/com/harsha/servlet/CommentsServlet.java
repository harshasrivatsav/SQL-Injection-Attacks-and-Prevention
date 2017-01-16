package com.harsha.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.dao.CommentDao;
import com.harsha.dao.LoginDao;


public class CommentsServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
		String n=request.getParameter("comments"); 
		HttpSession session = request.getSession(true);
		String name = "";
		if(session!=null){
			name = (String) session.getAttribute("name");
		}
		 
		
		
		CommentDao.validate(name, n);
		response.sendRedirect(request.getContextPath() + "/homepage.jsp");
			//RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");  
			//rd.forward(request,response);  
		out.close();  
	}  
}  


package com.harsha.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harsha.dao.LoginDao;
import com.harsha.dao.RegisterDao;

public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
		String fname=request.getParameter("firstname"); 
		String lname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String uname=request.getParameter("username");  
		String pass=request.getParameter("password");
		String confpass=request.getParameter("confirmpassword"); 
		
		
		Pattern pattern;
		Matcher matcher;
		
		final String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(email);
			boolean emailMatch = matcher.matches();
			HttpSession regSession = request.getSession(true);
			
		
		boolean emp = false;
		if(fname.equals("") || lname.equals("") || email.equals("") || uname.equals("") || pass.equals("") || confpass.equals("")){
			emp = true;
		}
		if(!emp){
			if(emailMatch){
				if(pass.equals(confpass)){
					boolean dataExists = RegisterDao.register(fname, lname, email, uname, pass);
					if(!dataExists){
						regSession.invalidate();
						out.print("<center><h2 style=\"color:black\">Registration Successful</h2></center>"); 
						RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
						rd.include(request,response);	
					}else{
						regSession.removeAttribute("validemail");
						regSession.removeAttribute("samepass");
						regSession.removeAttribute("fillall");
						regSession.setAttribute("sameuser", "true"); 
						RequestDispatcher rd=request.getRequestDispatcher("register.jsp");  
						rd.include(request,response); 
					}
					  
					
				}else{
					regSession.setAttribute("fname", fname);
					regSession.setAttribute("lname", lname);
					regSession.setAttribute("email", email);
					regSession.setAttribute("uname", uname);
					regSession.removeAttribute("validemail");
					regSession.removeAttribute("sameuser");
					regSession.removeAttribute("fillall");
					regSession.setAttribute("samepass", "true");
					RequestDispatcher rd=request.getRequestDispatcher("register.jsp");  
					rd.include(request,response);  
				}
			}else{
				regSession.removeAttribute("samepass");
				regSession.removeAttribute("sameuser");
				regSession.removeAttribute("fillall");
				regSession.setAttribute("validemail", "true");  
				RequestDispatcher rd=request.getRequestDispatcher("register.jsp");  
				rd.include(request,response);
			}
		}
		else{
			regSession.removeAttribute("samepass");
			regSession.removeAttribute("sameuser");
			regSession.removeAttribute("validemail");
			regSession.setAttribute("fillall", "true");  
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");  
			rd.include(request,response);  
		}
		out.close();  
	}  
}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Register</title>
</head>
<body>
<div class="stand">
  <div class="outer-screen">
    <div class="inner-screen">
      <div class="form">
      <form action="registerServlet" method="post">
      <% if (session.getAttribute("fname") == null) { %>
		    <input type="text" name="firstname" class="zocial-dribbble" placeholder="FirstName*" />
		<% } else {%>
		    <input type="text" name="firstname" class="zocial-dribbble" placeholder="FirstName*" value = "<%=session.getAttribute("fname")%>"/>
		<% } %>
        
        <% if (session.getAttribute("lname") == null) { %>
		    <input type="text" name="lastname" class="zocial-dribbble" placeholder="LastName*"/>
		<% } else {%>
		    <input type="text" name="lastname" class="zocial-dribbble" placeholder="LastName*" value = "<%=session.getAttribute("lname")%>"/>
		<% } %>
        <% if (session.getAttribute("email") == null) { %>
		    <input type="email" name="email" class="zocial-dribbble" placeholder="Email ID*"/>
		<% } else {%>
		    <input type="email" name="email" class="zocial-dribbble" placeholder="Email ID*" value = "<%=session.getAttribute("email")%>"/>
		<% } %>
        <% if (session.getAttribute("uname") == null) { %>
		   <input type="text" name="username" class="zocial-dribbble" placeholder="UserName*"/>
		<% } else {%>
		    <input type="text" name="username" class="zocial-dribbble" placeholder="UserName*" value = "<%=session.getAttribute("uname")%>"/>
		<% } %>
        
        <input type="password" name="password" placeholder="Password*" />
        <input type="password" name="confirmpassword" placeholder="Confirm Password*" />
         <input type="submit" value="Register" />
         <center>
         <% if (session.getAttribute("samepass") != null) { %>
		   <h3 style="font-family:Courier; color:Red;">Passwords did not match</h3>
		<% }%>
		<% if (session.getAttribute("sameuser") != null) { %>
		   <h3 style="font-family:Courier; color:Red;">Username or Email already exists</h3>
		<% }%>
				<% if (session.getAttribute("validemail") != null) { %>
		   <h3 style="font-family:Courier; color:Red;">Please enter valid Email</h3>
		<% }%>
				<% if (session.getAttribute("fillall") != null) { %>
		   <h3 style="font-family:Courier; color:Red;">Please fill all the fields</h3>
		<% }%>
		</center>
         </form>
      </div> 
    </div> 
  </div> 
</div>

</body>
</html>
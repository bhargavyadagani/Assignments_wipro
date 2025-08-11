<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		if(name.equals("admin") && password.equals("wipro"))
		{
			
	%>
			<h2>
				Login Sucessful
			</h2>
			<b>Name:</b> <%=name %>
			<b>Password</b> <%=password %>
	<% 
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
	%>
		
		
	
</body>
</html>
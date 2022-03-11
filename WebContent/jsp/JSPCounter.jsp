<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "cgm.pagedirective.Counter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% //out.println(Counter.getCount()); %>
	<%= Counter.getCount() %> <!-- Scriplet comment -->
	
	<% out.println();
	
		//DriverManager
		//Connecti
		
	%>

</body>
</html>
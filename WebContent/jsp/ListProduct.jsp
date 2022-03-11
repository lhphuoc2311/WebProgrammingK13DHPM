<%@page import="java.util.ArrayList"%>
<%@page import="cgm.ketnoicsdl.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%! List<Product> list; %>

	<% 
	Connection con = null;
	String user = "sa";
	String password = "123";
	
	String hostName = "localhost";
	
     String sqlInstanceName = "SQLEXPRESS";
     
     String database = "QLSach";
     //List<Product> list;
	
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	//String url = "jdbc:jtds:sqlserver://" + hostName + ":1433"
      //       + ";instance=" + sqlInstanceName + ";databaseName=" + database;
	
	String url = "jdbc:sqlserver://" + hostName + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
	ResultSet rs = null;
	try {
		con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		
		String sql = "SELECT * FROM PRODUCT";
		
		
		
		rs = stmt.executeQuery(sql);
		
		list = new ArrayList();
		
		 while(rs.next()) {
			 
			Product product = new Product();
			product.setCode(rs.getString("CODE"));
			product.setName(rs.getString("NAME"));
			product.setPrice(rs.getFloat("PRICE"));
			
			list.add(product);
			
			
		} 
		
		
		
		
		
		System.out.println(con.toString());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
	} %>


 <div align="center">
        <table border="1" cellpadding="3">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Price</th>
                
            </tr>
            <c:forEach var="product" items="${list}">
                <tr>
                    <td><c:out value="${product.code}" /></td>
                    <td><c:out value="${product.name}" /></td>
                    <td><c:out value="${product.price}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>   

</body>
</html>
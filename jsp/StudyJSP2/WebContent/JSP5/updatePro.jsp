<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/JSP5/updatePro.jsp</h1>
	<%
		request.setCharacterEncoding("UTF-8");
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String update_email = request.getParameter("email");
		
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
		
		String sql = "update itwill_member set email=? where id=? and pw=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, update_email);
		ps.setString(2, id);
		ps.setString(3, pw);
		
		ps.executeUpdate();
		
	%>
	
	
	
	
	
</body>
</html>
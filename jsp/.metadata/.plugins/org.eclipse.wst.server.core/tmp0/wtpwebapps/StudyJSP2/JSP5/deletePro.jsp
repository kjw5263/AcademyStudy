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
	<h1>WebContent/JSP5/deletePro.jsp</h1>
	<%
		//한글 처리
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		// 1 드라이버 로드
		Class.forName(DRIVER);
		// 2 디비 연결
		Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
		// 3 sql 작성 & pstmt 객체 생성
		String sql = "delete from itwill_member where id=? and pw=?";
		// 4 sql 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		pstmt.executeUpdate();
		
		System.out.println("삭제 성공");
	
	%>
</body>
</html>
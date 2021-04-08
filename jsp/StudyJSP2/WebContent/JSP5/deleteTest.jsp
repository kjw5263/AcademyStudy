<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/JSP5/deleteTest.jsp</h1>
	
	<%
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		// idx = 11번 사람의 정보를 삭제
		int idx = 10;	
		
		// 1) 드라이버 로드	
		Class.forName(DRIVER);
		out.print("드라이버 로드 성공");
		// 2) 디비 연결
		Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
		out.print("디비 연결 성공");
		// 3) sql 작성 & pstmt 객체 생성, ? 추가
		//		(sql - delete 구문, 특정 회원만 삭제 (10번))
		String sql = "delete from itwill_member where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		
		// 4) sql 실행
		pstmt.executeUpdate();
		out.print("delete 구문 실행 완료");
				
		
		
		
	%>
</body>
</html>
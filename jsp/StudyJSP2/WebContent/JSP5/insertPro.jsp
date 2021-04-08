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
	<h1>WebContent/JSP5/insertPro.jsp</h1>
	
	<%
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		//post 형식으로 받을 때 인코딩 방식 때문에 깨질 수 있음
		request.setCharacterEncoding("UTF-8");
		 
		// 이전 페이지에서 전달된 데이터 저장 -> 콘솔 출력 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		
		System.out.println("전달 정보 : "+ id + "/" + pw + "/" + email);
		
		// 전달받은 데이터 DB에 저장
		// 1단계 드라이버 로드
		Class.forName(DRIVER);
		// 2단계 디비 연결
		Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
		// 3단계 쿼리구문 및 pstmt 객체 생성
		String sql = "insert into itwill_member(id, pw, email) values (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, email);
		
		// 4단계 쿼리 실행
		pstmt.executeUpdate();
		
	%>
		
	
</body>
</html>
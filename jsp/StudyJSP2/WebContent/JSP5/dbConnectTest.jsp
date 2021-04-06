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
	<h1>WebContent/JSP5/dbConnectTest.jsp</h1>
	
	<h2> JDBC : (Java DataBase Connectivity) API</h2>
	-> Java와 DB(MySQL등)를 연결하도록 도와주는 프로그램(라이브러리)
	
	<%
		//0단계. 설치 : 해당 라이브러리 설치 (WEB-INF/lib/파일 추가) 1회
		//1단계. 라이브러리에서 필요한 드라이버 로드
				// Class라는 이름의 class 사용-드라이 이름 적어주기
				// ====> DB에 연결할 준비를 한것
		Class.forName("com.mysql.jdbc.Driver");
	
		System.out.println(" 드라이버 로드 성공! ");
		
		//2단계. 드라이버 로드 정보를 활용해서 디비 연결하기
		// Test Connection만 해본 것임!
		//DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "1234");
		
		// --> 연결을 유지하고 싶다면?
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "1234");
		
		System.out.println(conn);
		System.out.println(" 드라이버와 디비 연결 성공! ");
	
		
	
	%>
</body>
</html>
<%@page import="java.sql.Statement"%>
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
<h1>WebContent/JSP5/insertTest.jsp</h1>

	<%
		String name="itwill";
		String gender ="남";
		int age =30;
		String jumin="900101-123131";
		
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		//1단계. 드라이버 로드
		Class.forName(DRIVER);
		System.out.println(" 드라이버 로드 성공 ! ");
		//2단계. 디비 연결
		Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
		System.out.println(" DB 연결 성공 ! " + conn);
	
		
		//3단계. SQL 구문 작성 & statement객체 생성(->preparedstatement 변경 예정)
		//String sql = "insert into itwill_member (name, gender, age, jumin) values('테스트', '남',10, '100110-1111111')";
		String sql = "insert into itwill_member (name, gender, age, jumin) values('"+name+"', '"+gender+"', "+age+", '"+jumin+"')";
		// 아까 연결했던 정보를 가지고 준비를 한당
		// Statement : SQL구문을 실행하는 객체
		Statement stmt = conn.createStatement();
		
		
		// 4단계. SQL 구문을 실행 
		stmt.executeUpdate(sql);
		
		System.out.println(" 디비 정보 저장완료! ");
		
		
		// 하지만 하드코딩 하면 똑같은 데이터가 중복으로 DB에 들어간다->변수를 사용하자
	%>
</body>
</html>
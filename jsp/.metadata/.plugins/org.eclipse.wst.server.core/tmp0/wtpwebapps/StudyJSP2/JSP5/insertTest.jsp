
<%@page import="java.sql.PreparedStatement"%>
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
		
		// 1번 케이스) 하지만 하드코딩 하면 똑같은 데이터가 중복으로 DB에 들어간다->변수를 사용하자
		// String sql = "insert into itwill_member (name, gender, age, jumin) values('테스트', '남',10, '100110-1111111')";
		
		// 2번 케이스) statement를 사용하면 복잡하고, 어려워진다!
		// String sql = "insert into itwill_member (name, gender, age, jumin) values('"+name+"', '"+gender+"', "+age+", '"+jumin+"')";
		
		// 3번 케이스)
		String sql = "insert into itwill_member (name, gender, age, jumin) values(?,?,?,?)";
		
		
		// 아까 연결했던 정보를 가지고, DB 쿼리를 실행할 준비를 한다.
		// 2번 케이스 사용시) Statement : SQL구문을 실행하는 객체
		//Statement stmt = conn.createStatement();
		
		// 4단계. SQL 구문을 실행 
		//stmt.executeUpdate(sql);
		
		//pstmt.executeUpdate();
		// -> insert, update, delete 구문 실행시
		//pstmt.executeQuery();
		// -> select 구문 실행시 사용
		
		// 3번 케이스 사용시) PreparedStatement 클래스 말고 인터페이스 사용해야함
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		/* 바로 실행할 수 없음 -> ?를 채워주어야 한다! */
		// 	XXXXX는 컬럼의 데이터 타입에 따라서 변경한다.
		// pstmt.setXXXXX(parameterIndex, 저장할 값);
		pstmt.setString(1, name);
		pstmt.setString(2, gender);
		pstmt.setInt(3, age);
		pstmt.setString(4, jumin);
		
		pstmt.executeUpdate();
		
		
		
		/*
			Statement : SQL 구문을 실행하는 객체
			PreparedStatement : SQL 구문을 실행하는 객체
			* 차이점? -> 쿼리문을 실행할 준비가 되어있는 상태(Statement에 비해 처리속도 우수, 보안상 우수)
		
		*/
		
		
		
		System.out.println(" 디비 정보 저장완료! ");
		
		
		
		
		
		
		
	%>
</body>
</html>
<%@page import="java.sql.ResultSet"%>
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
	<h1> WebContent/JSP5/selectTest.jsp </h1>
	
	<%
		// 디비에 저장된 모든 회원의 정보를 출력(콘솔창과 화면에)
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		Class.forName(DRIVER);
		System.out.println("드라이버 로드 성공");
		
		Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
		System.out.println("DB 연결 성공");
		
		String sql = "select * from itwill_member";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// sql 구문 실행 후
		// ResultSet : select문의  결과(레코드셋 형태의 데이터)를 저장하는 객체
		ResultSet result = pstmt.executeQuery();
		
		
		// 데이터 처리 
		// next() -> 커서를 다음으로 넘겨라
		// 레코드셋의 데이터가 있을때, 커서는 항상 처음을 가리킨다 (커서 이동으로 데이터 읽기)
		
		// 데이터가 있을 때
		while(result.next()){
			// result.getXXXXX("컬럼명");
			// -> 가져오는 컬럼의 데이터 타입에 따라서 변경
			// => result객체의 커서가 가리키고 있는 한줄의 데이터 중에서 찾아오는 메소드
			// result.getXXXXX(컬럼인덱스);  -> 메소드 오버로딩, 컬럼의 인덱스는 1부터 시작한다
			
			// => 인덱스 번호를 사용하는 방법이 처리속도가 훨씬 빠르다.
			int idx = result.getInt(1);
			String name = result.getString(2);
			String gender = result.getString(3);
			int age = result.getInt(4);
			String jumin = result.getString(5);
			out.print("번호 : " +idx + ", 사용자 이름 : " + name + ", 성별 : " + gender + ", 나이 : " + age + ", 주민번호 : " + jumin + "<br>");
			
			
			
			
		}
		System.out.println("DB select 구문 실행 성공");
		
	
	
	
	%>
	
	
	
	
	
</body>
</html>
<%@page import="com.itwillbs.member.MemberBean"%>
<%@page import="java.sql.ResultSet"%>
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
	<h1>WebContent/member/info.jsp</h1>
	
	<h2> 회원 정보 조회 </h2>
	
	<%
		// 로그인한 사람의 정보를 DB에서 조회해서 
		// JSP 화면에 출력
		
		// 로그인 세션 처리 (로그인 안되어있으면 로그인 페이지로 이동)
		String id = (String)session.getAttribute("id");
		if(id == null){
			// 로그인 X
			System.out.println("[info.jsp] 아이디 없음 -> 로그인 페이지 이동");
			response.sendRedirect("loginForm.jsp");
		}
		// DB 연결 후 필요한 데이터 조회 -> 출력
		// 1. 드라이버 로드
		// 2. 디비 연결
		// 3. sql 구문 작성(select) & pstmt
		// 4. sql 객체 실행 -> rs에 저장
		// 5. 데이터 처리 (화면에 출력)
		// 
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
	
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
		String sql = "select * from itwill_member where id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs =  pstmt.executeQuery();
	
		MemberBean mb = null;
		
		// if문과 while문중에 뭘 써야할까?
		// 데이터가 하나, 한번만 받아올 때 if문을 써주는 것이 좋다 (고유한값을 부르는지 판단)
		// while은 몇개나 내가 받아올지 모를때 while 쓰는것이 좋음
		if(rs.next()){
			mb = new MemberBean();
			mb.setId(rs.getString("id"));
			mb.setPw(rs.getString("pw"));
			mb.setName(rs.getString("name"));
			mb.setAge(rs.getInt("age"));
			mb.setGender(rs.getString("gender"));
			mb.setEmail(rs.getString("email"));
			mb.setRegdate(rs.getTimestamp("regdate"));
			
			System.out.println(" SQL 구문 실행완료! ");
			System.out.println(" 저장된 회원정보 : " + mb);
		}
		
		
		
	%>
	<table border="1">
			<tr>
				<td>아이디</td>
				<td><%=mb.getId() %></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><%=mb.getPw() %></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=mb.getName() %></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><%=mb.getAge() %></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><%=mb.getGender() %></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%=mb.getEmail() %></td>
			</tr>
			<tr>
				<td>회원가입일</td>
				<td><%=mb.getRegdate() %></td>
			</tr>
		</table>
			
			
		<h2><a href="main.jsp"> 메인페이지로 이동</a></h2>
	
</body>
</html>
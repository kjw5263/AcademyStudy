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
	<h1>WebContent/member/list.jsp</h1>
	<h2> 회원 목록을 확인 (관리자) </h2>
	
	<%
		// 세션 제어 (관리자만 사용할 수 있음) -> 로그인 했다 하더라도, 아이디가 admin이 아니면 사용 불가
		String id = (String)session.getAttribute("id");
		
		if(id == null || !id.equals("admin")){
			System.out.println("[list.jsp] 로그인 세션 만료 또는 관리자 아님 ");
			response.sendRedirect("loginForm.jsp");
		}
		
	
		
		// DB에서 모든 회원의 정보 가져와서 처리(테이블에 출력)
		// DB접속 후 -> 정보 확인하고 나서 데이터 수정
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		
		%>
		
		<jsp:useBean id="mb" class="com.itwillbs.member.MemberBean"></jsp:useBean>
		<jsp:setProperty property="*" name="mb"/>
		<!-- db연동시 따로 선언되거나 연결되는 부분 없는거같은데 알아서 데이터 받아오나? -->
		<%
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
		String sql = "select * from itwill_member where id not in (?) ";
		// "select * from itwill_member where id != ?"
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		
		/* if(rs.next()){
			mb.setId(rs.getString("id"));
			mb.setPw(rs.getString("pw"));
			mb.setName(rs.getString("name"));
			mb.setAge(rs.getInt("age"));
			mb.setGender(rs.getString("gender"));
			mb.setEmail(rs.getString("email"));
		}
 */
	%>
	
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		
		<%
			while(rs.next()){
				
				%>
				<tr>
					<td><%=rs.getString("id") %></td>
					<td><%=rs.getString("pw") %></td>
					<td><%=rs.getString("name") %></td>
					<td><%=rs.getInt("age") %></td>
					<td><%=rs.getString("gender") %></td>
					<td><%=rs.getString("email") %></td>
					<td><%=rs.getString("regdate") %></td>
				</tr>
				
				<%
			}
		
		
		%>
	
	</table>
	
	
	
	
	
	
	
</body>
</html>
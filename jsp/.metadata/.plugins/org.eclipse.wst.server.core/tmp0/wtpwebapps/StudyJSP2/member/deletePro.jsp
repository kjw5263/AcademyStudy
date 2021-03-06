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
	<h1>WebContent/member/deletePro.jsp</h1>
	
	
	<%
		request.setCharacterEncoding("UTF-8");
		String id = (String)session.getAttribute("id");
		if(id == null){
			response.sendRedirect("login.jsp");
		}
	
	%>
	
	
	<!-- deleteForm.jsp에서 받아온(내가 폼에 입력해서 넘겨준) 데이터를 MemberBean객체 mb 생성해서
		setProperty가 데이터를 넣어준다
		그 이후 DB작업 함
	 -->
	<jsp:useBean id="mb" class="com.itwillbs.member.MemberBean"></jsp:useBean>
	<jsp:setProperty property="*" name="mb" />
	
	
	
	<!-- 삭제와 업데이트는 바로 하지 않는것이 좋다~ 
		본인확인을 한번 거친 후 진행하는 것이 좋음 -->
		
	
	
	
	<%
		// update처리 로직을 참고하여 회원정보를 삭제 기능 구현
		// DB접속 후 -> 정보 확인하고 나서 데이터 수정
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
		String sql = "select * from itwill_member where id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mb.getId());
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			if(mb.getPw().equals(rs.getString("pw"))){
				sql = "delete from itwill_member where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mb.getId());
				pstmt.executeUpdate();
				session.invalidate();	// 세션 쵸기화
				response.sendRedirect("main.jsp");
			} else {
				%>
				<script type="text/javascript">
					alert("비밀번호가 일치하지 않습니다.");
					history.back();
				</script>
				<%
			}
			
		} else {
			%>
				<script type="text/javascript">
					alert("해당하는 아이디가 없습니다.");
					history.back();
				</script>
			<%
		}
		
		
		
		
		
	
	%>
	
	
	
	
	
	
		
</body>
</html>
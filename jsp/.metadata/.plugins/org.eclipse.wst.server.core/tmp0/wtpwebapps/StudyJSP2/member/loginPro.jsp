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
 <h1>WebContent/member/loginPro.jsp</h1>
 
 <%
 	// 한글처리
 	request.setCharacterEncoding("UTF-8");
 	// 전달정보 저장 (자바빈객체 - 액션 태그) id/pw
 	String id = request.getParameter("id");
 	String pw = request.getParameter("pw");
 	/////////////////////////////////////////////
 	// DB이동 후 로그인 상태 판별

 %>
 
 	<jsp:useBean id="mb" class="com.itwillbs.member.MemberBean" />
 	<jsp:setProperty property="*" name="mb"/>
 	
 
 
 <%
 	System.out.println("전달 정보 : " + mb);
 
 
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	final String DBID = "root";
	final String DBPW = "1234";
	
	Class.forName(DRIVER);
	Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
	// 비밀번호만 알아 올 수 있도록 하기 
	String sql = "select pw from itwill_member where id=?";
	
 	PreparedStatement pstmt = conn.prepareStatement(sql);
 	
 	pstmt.setString(1, mb.getId());
 	
 	ResultSet rs = pstmt.executeQuery();
 	
 	// 데이터 처리
 	if(rs.next()){	// sql 구문의 결과가 있을 때
 		// 회원이다
 		// 비밀번호를 사용해서 본인 확인
 		if(mb.getPw().equals(rs.getString("pw"))) {
 			// 비밀번호가 같다 (====> 회원이다) => 본인 => 로그인 성공
 			
 			// 로그인 성공의 의미로, 회원 아이디 정보를 session내장 객체에 저장하기
 			session.setAttribute("id", mb.getId());
 			// mb.getId()는 String타입이지만, setAttribute의 value부분에는 Object형이 들어가야함
 			// ---> 업캐스팅 된다!
 			
 			
 			// main.jsp 페이지로 이동(2가지 경우)
 			// response.sendRedirect("main.jsp");
 			%>
 			
 			<script type="text/javascript">
 				alert("로그인성공!");
 				location.href="main.jsp";
 			</script>
 			
 			<%
 			
 		} else {	// 비밀번호가 다름 (회원이다)
 			// 비밀번호를 잘못 적엇다
 			%>
 			
 			<script type="text/javascript">
 				alert("비밀번호 오류!");
 				history.back();
 			</script>
 			
 			
 			<%
 		}
 	} else {
 		// 비회원이다
 		%>
			
			<script type="text/javascript">
			// confirm(" 비회원입니다. 회원가입 하시겠습니까? ")
			// y - 회원가입 페이지 이동, N - 페이지 뒤로가기
			
				var answer = confirm(" 비회원입니다. 회원가입 하시겠습니까? ");
				if(answer){
					location.href = "insertForm.jsp";
				} else {
					history.back();	
				}
				
			</script>
			
			
			<%
 	}
 	
 %>
 
 
 
</body>
</html>
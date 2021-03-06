<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.itwillbs.member.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WebContent/member/updatePro.jsp</h1>

<%
	// 로그인 세션
	String id = (String)session.getAttribute("id");
	if(id == null ){
		System.out.println("[updatePro.jsp] 로그인 세션 만료 ");
		// 참고로 한페이지에 sendRedirect는 하나만 있어야한다
		response.sendRedirect("loginForm.jsp");
	}

	// 한글처리
	request.setCharacterEncoding("UTF-8");
	
	// 전달되는 정보 (파라미터)를 저장 -> 액션태그 사용 자바빈 객체에 저장
	// MemberBean 객체 사용
	%>
		<jsp:useBean id="mb" class="com.itwillbs.member.MemberBean" />
		<jsp:setProperty property="*" name="mb"/>
	<%
	
	System.out.println("전달된 수정할 정보 : " + mb);
	

	
	
	// DB접속 후 -> 정보 확인하고 나서 데이터 수정
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	final String DBID = "root";
	final String DBPW = "1234";
	
	Class.forName(DRIVER);
	Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
	
	// 데이터를 수정할 거지만, 웬만하면 바로 수정을 안하는 것이 좋다 ! 
	// =====> DB 본인여부 확인 후 수정 여부를 결정
	String sql = "select * from itwill_member where id=?";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, mb.getId());
	ResultSet rs = pstmt.executeQuery();
	
	// 데이터 처리
	if(rs.next()){
		// 아이디에 해당하는 정보 있을 때
		if(mb.getPw().equals(rs.getString("pw"))){
			// 비밀번호까지 맞는 경우 : 수정 (비밀번호가 일치하는지까지 확인하여 본인여부 확인하기)	
			// DB연결까지 다 해놨으므로, sql (update) 만들고, pstmt객체 만들어서 실행하면돼
			sql = "update itwill_member set name=?, age=?, gender=?, email=? where id=?";
			pstmt = conn.prepareStatement(sql);	// sql문 하나당 pstmt 하나
			
			pstmt.setString(1, mb.getName());
			pstmt.setInt(2, mb.getAge());
			pstmt.setString(3, mb.getGender());
			pstmt.setString(4, mb.getEmail());
			pstmt.setString(5, mb.getId());
			
			pstmt.executeUpdate();
			
			System.out.println("회원 정보 수정 완료 !");
			// 페이지 이동
			response.sendRedirect("main.jsp");
		} else {
			// 비밀번호 틀리게 친 경우 => 오류 (페이지 뒤로 이동)
			%>
			<script type="text/javascript">
				alert("비밀번호가 일치하지 않습니다.");
				history.back();
			</script>				
			<%
		}
	} else {
		// 아이디에 해당하는 정보 없을 때 => 오류 (페이지 뒤로 이동)
		%>
		<script type="text/javascript">
			alert("아이디없음");
			history.back();
		</script>				
		<%

	}
	
	
	// 정상적인 수정 후 -> main.jsp 페이지 이동
	// 문제 발생 시 페이지 뒤로가기
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
%>


</body>
</html>
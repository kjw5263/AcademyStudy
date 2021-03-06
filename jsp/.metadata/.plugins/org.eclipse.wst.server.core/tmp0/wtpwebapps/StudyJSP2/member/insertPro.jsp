<%@page import="java.sql.Timestamp"%>
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
 <h1> WebContent/member/insertPro.jsp</h1>
<!-- 아이디, 비밀번호, 이름, 나이, 성별(라디오버튼), 이메일 -->
<%
	// DB에 저장할것임 -> 회원이 되는것!
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	
	// 전달 데이터 (파라미터값 저장 - 자바빈 객체로)
	%>
	
	
	<!-- 자바빈 객체 생성 -->
	<jsp:useBean id="mb" class="com.itwillbs.member.MemberBean"/>
	<!-- 전달되는 파라미터 값 -->
	<jsp:setProperty property="*" name="mb"/>
	
	<% 
		System.out.println("객체정보 : " + mb); // mb.toString() 과 같다
		/* 추가적인 회원가입 날짜 저장 */
		mb.setRegdate(new Timestamp(System.currentTimeMillis()));
		System.out.println("객체정보2 : " + mb);
	
		
	////-------------------------------------------
	// 해당 정보 이용해서 DB로 이동 저장
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	final String DBID = "root";
	final String DBPW = "1234";
	
	Class.forName(DRIVER);
	Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
	String sql="insert into itwill_member values(?,?,?,?,?,?,?)";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, mb.getId());
	pstmt.setString(2, mb.getPw());
	pstmt.setString(3, mb.getName());
	pstmt.setInt(4, mb.getAge());
	pstmt.setString(5, mb.getGender());
	pstmt.setString(6, mb.getEmail());
	pstmt.setTimestamp(7, mb.getRegdate());
	
	pstmt.executeUpdate();
	
	System.out.println("회원가입 성공");
	
	
	
	// 로그인 페이지로 이동

%>


	<script type="text/javascript">
		alert(" 회원가입 성공! ");
		location.href = "loginForm.jsp";
		
	</script>






















</body>
</html>
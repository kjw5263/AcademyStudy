<%@page import="com.itwillbs.member.MemberBean"%>
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
 <h1>WebContent/member/insertForm.jsp</h1>
 
 <h2> 회원 정보 수정 </h2>
 
 <%
 	String id = (String)session.getAttribute("id");
 	if( id == null ){
 		System.out.println("[updateForm.jsp] 로그인 세션 만료 ");
 		response.sendRedirect("loginForm.jsp");
 	}
 	
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	final String DBID = "root";
	final String DBPW = "1234";
	
	Class.forName(DRIVER);
	Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
	String sql = "select * from itwill_member where id=?";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	ResultSet rs = pstmt.executeQuery();
	
	MemberBean mb = null;
	if(rs.next()){
		mb = new MemberBean();
		mb.setId(rs.getString("id"));
		mb.setPw(rs.getString("pw"));
		mb.setGender(rs.getString("gender"));
		mb.setName(rs.getString("name"));
		mb.setAge(rs.getInt("age"));
		mb.setEmail(rs.getString("email"));
	}
	
 
 
 %>

 <% 
 if (mb != null ){
	 %>
 
	 <form action="updatePro.jsp" method="post">
	 <!-- readonly 속성 : 값 변경 X, 데이터 전송(submit) O
	 	  disabled 속성 : 값 변경 X, 데이터 전송(submit) X   -->
	  아이디 : <input type="text" name="id" value="<%=mb.getId()%>" readonly> <br>
	  비밀번호 : <input type="password" name="pw" placeholder ="비밀번호 입력해주세요"> <br> 
	  <hr>
	  이름 : <input type="text" name="name" value="<%=mb.getName() %>"> <br>
	 나이 : <input type="text" name="age" value="<%=mb.getAge() %>"> <br>
	 성별 : <input type="radio" name="gender" value="남" 
	 	<%  if(mb.getGender().equals("남")){
	 			%> 	checked = "checked" <%
	 		} 		
	 	%>
	 	> 남
	<input type="radio" name="gender" value="여"> 여 <br>
	 이메일 : <input type="text" name="email" value="<%=mb.getEmail() %>"> <br>
	  <hr>
	  <input type="submit" value="수정">
	
	 
	 </form>
	 
	 <% 
 }
 %>
 
</body>
</html>
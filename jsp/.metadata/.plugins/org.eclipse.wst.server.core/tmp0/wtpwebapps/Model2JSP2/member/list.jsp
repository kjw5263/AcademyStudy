
<%@page import="com.member.db.MemberDTO"%>
<%@page import="java.util.List"%>
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
	<h2> 회원 목록을 확인 (관리자) (Model2)</h2>
	<%
		// request.setAttribute("memberList", memberList ); 이렇게 보내줬기 떄문에!
		List memberList = (List)request.getAttribute("memberList");
	
	
	%>
	
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>비밀번호</th>
			<th>아이디</th>
			<th>나이</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		
	   <% for(int i=0; i<memberList.size(); i++){ 
	   		MemberDTO dto = (MemberDTO)memberList.get(i);
	   %>
		<tr>
			<th><%=dto.getName() %></th>
			<th><%=dto.getPass() %></th>
			<th><%=dto.getId() %></th>
			<th><%=dto.getAge() %></th>
			<th><%=dto.getEmail() %></th>
			<th><%=dto.getReg_date() %></th>
		</tr>
		<% } %>
	</table>
	
	<h2><a href="./Main.me">메인 페이지로...</a></h2>
	
	
	
	
	
</body>
</html>
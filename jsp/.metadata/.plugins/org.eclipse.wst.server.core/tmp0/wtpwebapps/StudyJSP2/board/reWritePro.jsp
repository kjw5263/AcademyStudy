<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1> WebContent/board/reWritePro.jsp</h1>
 
 <%
	//한글 처리
	request.setCharacterEncoding("UTF-8");
    // 전달되는 파라미터 값 저장하기
 	
 	
 %>
 
 
 <jsp:useBean id="reWriteBean" class="com.itwillbs.board.BoardBean"/>
 <jsp:setProperty property="*" name="reWriteBean"/>
 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	*****************웹 서버 쪽의 서버페이지 ******************
	안드로이드 앱으로부터 입력한 값 해당 jsp 로 받기
	

 --%>
 
 <%
 	// 안드로이드 AVD 상대방 측으로 부터 넘어온 데이터를 변수에 저장
 	String id = request.getParameter("id");
 	String pass = request.getParameter("pass");
 	
 	System.out.println("id="+id+", pass="+pass);
 	
 
 %>
</body>
</html>
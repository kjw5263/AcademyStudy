<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 안녕하세요 JSP 파일 (js4/test.jsp) </h1>

<% 
	// Java 코드를 쓸 수 있다.
	String id = request.getParameter("id");
	String hobby = request.getParameter("hobby");

	String[] str = request.getParameterValues("hobby");
	if(str != null){
		for(int i=0; i<str.length; i++){
			out.println(str[i]);
		}
	}
	
%>





</body>
</html>
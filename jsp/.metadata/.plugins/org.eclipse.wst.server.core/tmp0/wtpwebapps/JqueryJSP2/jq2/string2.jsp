<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 전달해준 데이터를 저장 -> 출력
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");

	
	int age = Integer.parseInt(request.getParameter("age"));
	System.out.println(name + " , " + age);
%>

<%=name%>-<%=age%>
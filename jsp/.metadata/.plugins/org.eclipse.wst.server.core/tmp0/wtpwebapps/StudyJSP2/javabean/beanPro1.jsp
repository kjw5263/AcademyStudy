
<%@page import="com.itwillbs.beantest.Javabean1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/javabean/beanPro1.jsp</h1>
	<%
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		// 전달된 정보 저장 (파라미터)
		String id = request.getParameter("id");
		
		////////////////////////////////////////////////
		// com.itwillbs.beantest 패키지에 javabean1 객체 생성하려고 해여
		// id 정보를 저장할수 있도록 하자
		Javabean1 jb = new Javabean1();
		// => 전달된 파라미터를 객체를 사용해서 저장후 출력
				
		jb.setId(id);
		//jb.setId(request.getParameter("id")); 가능!
		
		
		///////////////////////////////////////////////////////
		// 자바 파일 거치는건 너무 비효울 적이야!
		// => JSP 에서는 [액션태그]를 사용하여 자바빈 객체 전달
		
		
	%>
	
	<%--  이 액션태그가 자바빈 객체를 알아서 불러다가 값을 전달해준다
	<jsp:useBean id="객체명(레퍼런스명)" clas="클래스의 위치(패키지명)"/>
	--%>
	
	
	<% 
		//Javabean1 jbAction = new Javabean1();
		// 아래 액션태그와 같은 의미!!
	%>
	<jsp:useBean id="jbAction" class="com.itwillbs.beantest.Javabean1" />
	<jsp:setProperty property="id" name="jbAction"/>
	<%
		// setProperty 태그 : request.getParameter(arg0) + jbAction.setId(id)를 같이 사용하는 것과 같다 
		// param과 property가 같을 땐, param 생략 가능 
		// property에 *를 사용하면, 모든 변수에 값을 알아서 넣겠다는 의미이다  %> 
	
	아이디 : <%=id %> <br>
	아이디 (객체사용) : <%=jb.getId() %> <br>
	<jsp:getProperty property="id" name="jbAction"/>
</body>
</html>
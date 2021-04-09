<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/JSP2/scopePro.jsp </h1>
	
	<h2> 전달된 파라미터값을 저장 후 출력 </h2>
	<%
		String id = request.getParameter("id");
	%>
	
	아이디 : <%=id %><br>
	
	<%
		// 영역 객체를 사용하려면 해당 영역에 일단 데이터를 저장해야한다
		// 영역 데이터 저장
		// 즉, 해당 영역에 데이터를 저장 -> 해당 영역에서 데이터를 공유해서 사용 가능
		// 영역객체.setAttribute("이름", 값);
		
		// 영역 데이터 사용
		// 영역객체.getAttribute("이름");
		
		// 영역의 크기 A>S>R>P
		
		////////////////////////////////////////////////////////
		
		pageContext.setAttribute("page", "page영역 객체 정보");
		pageContext.setAttribute("page1", "page영역 객체 정보");
		request.setAttribute("req", "request객체 정보(itwill)");
		session.setAttribute("ses", "session객체 정보(itwill)");
		application.setAttribute("app", "application객체 정보(itwill)");
		
		
	
	
	%>
	
	<h2> 영역객체의 값을 출력-> 같은 영역안에 있는 애들끼리 값을 꺼내쓸 수 있다. </h2>
	pageContext 내장 객체 공유데이터(속성) : <%=pageContext.getAttribute("page") %><br>
	request 내장 객체 공유데이터(속성) : <%=request.getAttribute("req") %><br>
	session 내장 객체 공유데이터(속성) : <%=session.getAttribute("ses") %><br>
	application 내장 객체 공유데이터(속성) : <%=application.getAttribute("app") %><br>
	
	
	<hr><hr>
	
	<h2> 페이지 이동시 사용가능한 데이터 </h2>
	
	1. a 태그 사용<br>
	파라미터 값 전달 가능 + 
	영역객체 : session, application 정보만 사용 가능
	<a href="scopePro2.jsp?id=<%=id%>&pw=qwerty"> scopepro2.jsp 페이지 이동</a> <br>
	
	<hr>
	2. javascript 사용 <br>
	<script type="text/javascript">
		//alert('scopePro2.jsp 페이지로 이동 ');
		//location.href="scopePro2.jsp?id=<%=id%>&pw=1234";
	</script>
	
	
	
	3. JSP 사용 <br>
	실행순서 jsp -> js <br>
	파라미터 값 전달 가능 + 
	영역객체 : session, application 정보만 사용 가능 <br>
	<%
		System.out.println("scopePro.jsp 페이지 실행!");
		//response.sendRedirect("scopePro2.jsp?id="+id+"&pw=1234"); // 특정 페이지로 이동할 수 있는 메소드 
		// 스크립틀릿은 지역변수의 개념을 갖고있기 때문에
		// 변수를 주고싶다면 스크립틀릿 대신 변수사용하듯이 사용하면 됨
		// scopePro2.jsp?id=admin 이런식으로 담겨있는 것임
		// -> 값을 보냈음에도 불구하고 request속성이 null
		
		
	%>
	
	
	
	4. jsp 액션태그 (forward 방식)
	<br> 포워딩 방식 이동 : 페이지 이동시 request, response 포함해서 이동하는 방식
	<br> 			A -> B
	<br> 페이지 주소 : A
	<br> 페이지 화면 : B
	<br> ==> 페이지 주소변경X, 페이지 화면 변경O, request, response 가지고 이동
	
	
	<br> 파라미터 전달가능
	영역객체 : request, session, application 정보만 사용가능 <br>
	
	<%-- <jsp:forward page="scopePro2.jsp?pw=1234"> --%>
	<jsp:forward page="scopePro2.jsp">
		<jsp:param value="12341234" name="pw"/>
	</jsp:forward>
	
	// 주소는 A.nhn으로 하고싶지만, 화면은 B.jsp로 띄우고싶을때 forward 사용
	// form --> pro --(forward)--> pro2
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>
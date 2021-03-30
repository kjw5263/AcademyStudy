<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1> WebContent/JSP1/testPro1.jsp </h1>
  
  <%
  	// JSP 코드 작성(java 코드) 가능
  	
  	// 요청 객체(request)로 부터 전달된 정보를 사용할 수 있도록 하기
  	
  	// 이전 페이지에서 전달되는 정보 = 파라미터
  	// request.getParameter("파라미터명");
  	String num = request.getParameter("num"); 	//객체 사용하려면 객체 만들어야하지만, 내장 객체라서 생성 안해도됨
  	// ----> 전달된 모든 파라미터는 String 타입으로 저장됨
  	
  	
  	// Integer.parseInt("문자열값");
  	// ===> 문자열 숫자 "11"를 실제 정수로 변경
  	
  			
  	int num2 = Integer.parseInt(request.getParameter("num"));
  	// ----> 그냥 이파일만 실행했을 땐, null 을 int로 변형하려 하므로 NumberFormatException 발생
  	
  	
  
  %>
  
    전달받은 숫자 : <%=num %> <br>
    전달받은 숫자 + 100 : <%=num+100 %> <br>
    전달받은 숫자(정수로 변경) + 100 : <%=Integer.parseInt(num) + 100 %> <br>
  
  
  
  
  
</body>
</html>
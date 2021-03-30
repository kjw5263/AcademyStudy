<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1> WebContent/jsp1/testPro.jsp </h1>
  
  <%
  		// 자바 코드 작성
  		
  		/* 한글처리 (인코딩 복구) */
  		request.setCharacterEncoding("UTF-8");
  		
  		String name = request.getParameter("myName");
  		int age = Integer.parseInt(request.getParameter("myAge"));
  
  		
  %>
  
   이름 : <%=name %> <br>
   나이 : <%=age %>
   
   <hr>
   
   <h2> 회원정보 확인</h2>
  <h3> 회원의 나이가 20살 미만이면 "수업 참여 불가"<br>
  				 20살 이상이면 "수업참여 가능"</h3>


	<%
		String result = "";
		if(age >= 20){
			result = "수업 참여 가능";
			// out.print(" 수업참여 가능 ");
			// out.print(" <h3> 수업 참여 가능 </h3>");
			%>
				<h3> 수업 참여 가능 </h3>
			<%
		} else {
			result = "수업 참여 불가";
			%>
			<h3> 수업 참여 불가 </h3>
			<%
		}
	
	
	%>


나이 : <%=age + " " + result %>








</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/JSP4/cookiePro.jsp</h1>
	
	<%
		String reqVal = request.getParameter("lang");
		Cookie cookie = new Cookie("LangCook", reqVal);
		// 쿠키 시간 설정해주어야 함! 안그러면 사라져
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
	
	
	
	%>
	
	
	<script type="text/javascript">
		alert("쿠키 만들었어요!");
		location.href="cookieForm.jsp";
	
	
	</script>
	
	
	
</body>
</html>
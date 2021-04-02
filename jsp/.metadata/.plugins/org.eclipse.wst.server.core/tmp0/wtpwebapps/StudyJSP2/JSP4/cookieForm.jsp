<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/JSP4/cookieForm.jsp</h1>
	"안녕하세요. 쿠키 연습!" or "Hello, Cookie Test!" 출력 <br>
	브라우저 창을 껐다가 켜도, 선택한 언어의 인삿말이 나타나도록 하기<br>
	
	<%
		Cookie[] cookies = request.getCookies(); 
		String value="";
		String result ="";
		if(cookies != null){
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("LangCook")){
					value = cookies[i].getValue();
				}
				if(value.equals("kor")){
					result = "안녕하세요, 쿠키 연습!";
				} else if(value.equals("eng")){
					result ="Hello, Cookie!";
				}
			}
		}
	
	%>
	
	
	
	<hr> 결과 데이터 : <%=result %><hr>
	<form action="cookiePro.jsp" name="fr" method="post">
		<input type="radio" name="lang" value="kor" 
			<%  if(value.equals("kor")){  %>  checked  <% }	%> > 한국어
		<input type="radio" name="lang" value="eng"
		<%  if(value.equals("eng")){ %>	checked	<% } %>	> 영어
		<hr>
		<input type="submit" value="전송">
	</form>
	
	
	
</body>
</html>
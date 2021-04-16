<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% // 로그아웃 하기
		// 세션 초기화
		session.invalidate();
		// session.removeAttribute();	// 이걸 써도 되지만, 로그아웃 기능이기 때문에 특정 속성만 지우기 보다는 전체를 초기화 해주는 것이 좋다 .

		
		%>
		
	<script type="text/javascript">
		alert("정상적으로 로그아웃 했습니다.");
		location.href='main.jsp';
	</script>	
</body>
</html>
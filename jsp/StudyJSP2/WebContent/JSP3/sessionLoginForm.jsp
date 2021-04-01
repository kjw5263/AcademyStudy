<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
	<h1>WebContent/JSP3/sessionLoginForm.jsp</h1>
	
	<!-- 로그인 처리 로직 -->
	<!-- 
		1) 아이디, 비밀번호 입력받기 -> sessionLoginPro.jsp
		2) 아이디, 비밀번호가 ["itwill","1234"]인지 판단
		2-1) 아이디 유무, 비밀번호 동일 유무
		2-2) 문제가 발생한 경우 (아이디X, 비밀번호 틀린경우) - 각각 메시지 출력
		2-3) 문제 없을 경우 페이지 이동, sessionMain.jsp + id정보를 세션값으로 생성
		3) sessionMain.jsp에서 "id님 로그인 성공!" 출력
		4) logout 버튼 생성 (sessionLogout.jsp)
	 -->
	
	<fieldset>
		<legend> 로그인 </legend>
		<form action="sessionLoginPro.jsp" method="post">
			아이디 : <input type="text" name="id"> <br>
			비밀번호 : <input type="password" name="pw"> <br>
			<input type="submit" value="제출">

		</form>
	</fieldset>
	
	
</body>
</html>
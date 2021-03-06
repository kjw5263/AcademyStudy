<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> WebContent/member/main.jsp</h1>
	
	<%
		// 사용자가 로그인 했을 때만 main 페이지 확인
		// 로그인 안한경우 로그인 페이지로 이동
		
		// session 객체 정보를 가져와서 확인하기
		String id = (String)session.getAttribute("id");
		// 앞서 loginPro.jsp에서 session.getAttribute의 value값을 object형식으로 업캐스팅했고
		// 여기서 다시 String으로 다운캐스팅한다.
		
		// 왜 업캐스팅, 다운 캐스팅을 하나?
		// 업캐스팅 : Object라는 객체로 업캐스팅 하면, 한 덩어리로 들고 다녀야 해서 전달이나 이동이 편리
		//			단점, 하나로 묶어 전송하다보니 안에 무슨내용이 들어있는지 모른다.
		// 다운캐스팅 : 안에 묶은 내용을 풀어서 값을 꺼내오는 것을 다운캐스팅이라고 함 (이미지 참고)
	
	
		if(id == null){
			// 로그인 X
			System.out.println("[main.jsp] 아이디 없음 -> 로그인 페이지 이동");
			response.sendRedirect("loginForm.jsp");
		}
		
	
	%>
	
	<h2> <%=id %>님, 환영합니다!</h2>
	
	<input type="button" value="로그아웃" onclick=" location.href = 'logout.jsp'">

	
	
	<hr>
	
	
	
	<h3> <a href="info.jsp"> 회원 정보 조회 </a></h3>
	
	
	<h3> <a href="updateForm.jsp"> 회원정보 수정</a></h3>

	
	<h3> <a href="deleteForm.jsp"> 회원 탈퇴 </a></h3>
	
	
	<!-- 아이디가 Null 일 때, NullPointerException 
		null과 문자열은 비교 자체 불가!  -->
		
	<%
		// 참조형 데이터 값 비교시 항상 null값 먼저 비교 후 데이터 비교 해야함
		if(id != null && id.equals("admin")) {
	%>
	
	<h3><a href="list.jsp"> 회원 목록 보기 </a></h3>
	
	
	
	<%
	}
	%>
	
	
	
	
</body>
</html>
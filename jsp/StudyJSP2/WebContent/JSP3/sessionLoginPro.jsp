<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/JSP3/sessionLoginPro.jsp</h1>
	
	<%
		// 한글처리 - 파라미터 받기 전에 설정 해주기
		request.setCharacterEncoding("UTF-8");
	
		// 전달받은 정보 (파라미터 저장)
		String id = request.getParameter("id");	// id변수는 주소가 들어가있다!
		String pw = request.getParameter("pw");
		
		System.out.println("id : "+ id + " pw : " + pw);
		
		String dbID = "itwill";
		String dbPW = "1234";
		
		
		
		
		// 로그인 처리 로직
		if(id.equals(dbID)){
			//-> equals 메소드 : 값이 같은지 비교하는 메소드
			// ==> 아이디가 같은 경우
			if(pw.equals(dbPW)){
				// 아이디 + 비번 동일 -> 로그인 성공
				// ==> 세션값 생성하기
				session.setAttribute("id", id);
				
				// ====> 페이지 이동
				response.sendRedirect("sessionMain.jsp");
			} else {
				// 비밀번호가 틀린 경우
				out.println("비밀번호가 틀렸습니다.");
			}
			
			
		} else {
			// ==> 아이디가 다른 경우
			out.println("아이디 정보가 없습니다");
		}
		
		
	%>
	
	
</body>
</html>
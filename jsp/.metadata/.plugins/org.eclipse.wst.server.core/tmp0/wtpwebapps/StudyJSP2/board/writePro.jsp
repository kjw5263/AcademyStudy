<%@page import="com.itwillbs.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>2. writePro.jsp</title>
</head>
<body>
	<h1>WebContent/board/writePro.jsp</h1>
	
	<%
		request.setCharacterEncoding("UTF-8");
	
		// 전달되는 정보(파라미터) 저장- 액션태그 : 자바빈 객체
		// com.itwillbs.board.BoardBean 자바빈 객체 생성
		
	%>
	
	<!-- 얘로 인해 객체 생성을 한다, 기본 생성자로 인해 초기값으로 설정받는다 -->
	<jsp:useBean id="bb" class="com.itwillbs.board.BoardBean"></jsp:useBean>
	<jsp:setProperty property="*" name="bb"/>
	
	<%
		// ip정보 추가
		bb.setIp(request.getRemoteAddr());
		System.out.println("글쓰기 정보 : " + bb.toString()); // bb.toString() 받아온 내용을
	
		// DB에 대한 처리를 하는 객체 생성 -> 먼저 BoardDAO.java 파일 만들어야 함
		BoardDAO bdao = new BoardDAO();
		
		// 글쓰기 기능을 사용
		bdao.insertBoard(bb);	// 여기서 받는다! 
		//System.out.println(bdao.toString());
		//bdao.getConnection();	
		// getConnection메소드가 public일 시 사용가느, private일 시 접근 못함
		
		// 글 쓴 후, 글 목록으로 이동
		response.sendRedirect("list.jsp");
	
	%>
	
</body>
</html>
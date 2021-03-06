<%@page import="com.itwillbs.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>WebContent/board/updatePro.jsp</h1>
 
 <%
 	request.setCharacterEncoding("UTF-8");
 	// 이전페이지에서 전달된 데이터 저장하기
 	String pageNum = request.getParameter("pageNum");
 	
 	// 이전 페이지에서 전달된 데이터 저장(파라미터)
 	// => 액션 태그
 	
 
 %>
 
   <jsp:useBean id="bb" class="com.itwillbs.board.BoardBean"/>
   <jsp:setProperty property="*" name="bb"/>


	<%
		System.out.println("수정할 정보 : " + bb);
		
		// DB 처리 객체 BoardDAO 생성
		BoardDAO bdao = new BoardDAO();
		// 해당 글 정보를 사용해서 글 내용 수정
		int check = bdao.updateBoard(bb); // bb안에 수정할 내용들이 있으니까 bb 넘겨주기!
		
		System.out.println("check : " + check);
		// 페이지 이동 (자바 스크립트 사용)
		// check => 1, 0, -1 경우
		
		// 1 (정상적으로 수정완료)
		if(check == 1){
			%>
				<script type="text/javascript">
				   alter("수정 완료되었습니다.");
				   location.href="list.jsp?pageNum=<%=pageNum%>";
				</script>
			<%
		} else if(check == 0){
			%>
				<script type="text/javascript">
				  alert("비밀번호 오류입니다.");
				  history.back();
				</script>
			<%
		} else if(check == -1){
			%>
			<script type="text/javascript">
			  alert("해당 글이 업습니다.");
			  history.back();
			</script>
			<%
		}
		
		// 0 (글은 있지만, 비밀번호 오류 - 수정 실패 )
		
		// -1 (없는글에 접근 - 수정 실패 )
		
		
		
	%>
 
 
 
 
</body>
</html>
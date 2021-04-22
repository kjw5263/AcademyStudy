<%@page import="com.itwillbs.board.BoardBean"%>
<%@page import="java.util.ArrayList"%>
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
	<h1>WebContent/board/list.jsp</h1>
	
	<%
		// 디비에 저장된 글의 개수를 알기
		
		// BoardDAO 객체 생성
		BoardDAO bdao = new BoardDAO();
		// 디비의 글의 수를 계산하는 메서드 생성 -> 호출
		// getBoardCount();
		bdao.getBoardCount();
		
		int cnt = bdao.getBoardCount();
		
		///////////////////////////////////////////////////////////
		// 게시판 페이징 처리 : DB에서 원하는 만큼만 글 가져오기
		
		// 한페이지당 보여줄 글의 개스
		int pageSize = 5;
		
		// 현 페이지가 몇페이지 인지 확인
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null ){
			pageNum = "1";
		}
		
		// 페이지별 시작행 계산하기
		// 1p -> 1번
		// 2p -> 11번, 3p -> 21번 ... => 일반화
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		
		// 끝행 계산하기
		// 1p -> 10번, 2p->20번. 3->30번 일반화
		int endRow = currentPage * pageSize;
		
		
		/////////////////////////////////////////////////////////////	
		
		// DB에 저장된 모든 글 정보 가져오기
		//ArrayList boardListAll = bdao.getBoardList();
		
		
		// 이젠, DB에 저장된 모든 글 중에 원하는 크기 만큼(pageSize)만 가져오기
		ArrayList boardList = bdao.getBoardList(startRow, pageSize);
		
	%>

	
	
	<h2> ITWILL 게시판 글 목록 [총 <%=cnt %>개]</h2>
	<h3><a href="writeForm.jsp">글쓰기</a></h3>
	
	<table border="1">
	  <tr>
	    <th>번호</th>
	    <th>제목</th>
	    <th>작성자</th>
	    <th>작성일</th>
	    <th>조회수</th>
	    <th>IP</th>
	  </tr>
	  
	  <%
	  	for(int i=0; i<boardList.size(); i++) {
	  		BoardBean bb = (BoardBean) boardList.get(i);
	  		%>
	  			<tr>
	  				<td><%=bb.getNum() %></td>
	  				<td><%=bb.getSubject() %></td>
	  				<td><%=bb.getName() %></td>
	  				<td><%=bb.getDate() %></td>
	  				<td><%=bb.getReadcount() %></td>
	  				<td><%=bb.getIp() %></td>
	  			</tr>	
	  		<%	  		
	  	}
	  %>
	</table>
	
	<hr>
	
	<%
		////////////////////////////////////////////////////
		// 페이징 처리 - 하단부 페이지 링크
		// cnt : 글 개수
		if(cnt != 0){	// 글이 있을 때 표시
			// 전체 페이지 수 계산
			// ex) 총 50개 -> 한페이지당 10개 출력, 5개
			// 		총 57개 -> 한 페이지당 10개, 6개
			int pageCount = cnt/pageSize + (cnt % pageSize == 0? 0:1);
			
			// 한 화면에 보여줄 페이지 번호의 개수 (페이지 블록 )
			int pageBlock = 5;
			
			// 페이지 블럭의 시작페이지 번호
			// ex) 1~10 페이지 : 1, 11~20페이지 : 11, 21~20 패이지 : 21
			int startPage = ((currentPage-1)/pageBlock) * pageBlock + 1;
			// ex) 1~5 페이지 : 1, 6~11 페이지



			// 페이지 블럭의 끝 페이지 번호
			int endPage = startPage+pageBlock-1;

			if(endPage > pageCount ){
				endPage = pageCount;
			}
			
			
			
			// 이전
			
			
			// 숫자 1...10
			for(int i=startPage; i<=endPage; i++){
				%>
					<a href="list.jsp?pageNum=<%=i %>"> [ <%=i %> ] </a>
				<%
			}
			
			// 다음
			
			
			
			
			
			
			
		}
		
		
		///////////////////////////////////////////////////
	
	
	%>
	
	
	
	
	
</body>
</html>
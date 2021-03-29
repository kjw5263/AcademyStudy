<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> WebContent/jsp1/test2.html </h1>
	
	<% 
		// 스크립틀릿 작성 - java 코드
		// 문자열 배열 - 4칸
		// "java", "jsp", "web", "DB"
		
		String[] strArr = {"java", "jsp", "web", "DB"};
		// String[] subject = new String[]{"java", "jsp", "web", "DB"};
/* 		String[] arrStr = new String[4];
		arrStr[0] = "java";
		arrStr[1] = "jsp";
		arrStr[2] = "web";
		arrStr[3] = "DB"; */
	
		// strArr 배열의 모든 요소의 값을 콘솔창에 출력
		for(int i=0; i<strArr.length; i++){
			System.out.println(strArr[i]);
		}
		
		// 확장 for문, for each문
		// for(String s : strArr){ System.out.println(s); }
		
		
		// 화면에 출력-> out.print(), out.println() 사용
		// *html 코드로 작성 (줄 바꾸기 할 때 "<br>" 태그 필요)
		// * out.print(" 쌍따옴표 안에 작성하는 코드는 html 코드로 작성!!! ");
		for(int i=0; i<strArr.length; i++){
			out.println(strArr[i] + "<br>");
		}
		
		
		
		
		// 표현식을 사용해서 화면에 출력하기
		for(int i=0; i<strArr.length; i++ ){
			%>
			 <!-- HTML 부분 -->
			 <!-- jsp 표현식은 html 코드에 작성 -->
			  
			 <hr>
			 strArr[<%= i %>] = <%=strArr[i] %>		
			
			
			 <!-- HTML 부분 -->
			<%
		}

		
	%>
	
	<!-- HTML 부분 --> 
	
	<h3> 테이블 생성 </h3>
	<!-- 번호 1~4, 과목이름, 과목내용 (과목이름 + 번호)
		java코드 : strArr 배열의 요소를 html 테이블에 출력 -->
	
	<table border="1">
	<tr>
		<th>번호</th>
		<th>과목이름</th>
		<th>과목내용</th>
	</tr>
 	<%
 		for(int i=0; i<strArr.length; i++){
 			%>
 			 <tr>
 				<td><%=i+1 %></td>
 				<td><%=strArr[i] %> </td>
 				<td><%=strArr[i] + (i+1) %> </td>
 			 </tr>
 			<%
 		}
 	%>
	</table>
	
	
	
	
	
</body>
</html>
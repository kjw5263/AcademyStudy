<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="color.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="<%=col1 %>" >
	<h1> WebContent/JSP2/includeTest.jsp </h1>
	
	<h4> 
		include 기술을 사용하여, 중복사용된 페이지를 줄임 <br>
		1) {%@ include ~   %} (JSP 지시어) <br>
		컴파일 되기 전에, 소스코드를 결합 후 컴파일을 함 (1개의 파일로 생성) <br><br>
			=> 페이지에서 사용될 공통의 값 (변수) <br>
		
		2) {jsp:inlcude page=""}{/jsp:include} (JSP 액션태그) <br>
		액션태그 : 태그를 사용해서 다른 동작(jsp)을 실행가능한 코드의 형태 (jsp코드처럼 쓰이는 코드) <br>
		각각의 파일을 컴파일 후, 해당 코드에 추가(여러개의 파일이 추가된 1개의 파일)
			=> 특정 페이지를 해당 페이지에 추가할 때 <br>
		
	</h4>
	
	<table border="1" width="600" height="600">
		<tr>
			<td colspan="2" height="100">
				<!-- 액션태그엔 jsp 코드만 사용가능 -->
				<jsp:include page="top.jsp">
				  <jsp:param value="itwill" name="id"/>
				</jsp:include>
				<!-- include가 top을 부를때 값을 넘겨주고, top은 그 데이터를 받아 출력하기 -->
			
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="left.jsp"></jsp:include>
			</td>
			<td width="400"> 
				<img src="3.jpg" width="400" height="400">
			</td>
		</tr>
		<tr>
			<td colspan="2" height="100">
				<jsp:include page="bottom.jsp"></jsp:include>
			</td>
		</tr>
	
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>
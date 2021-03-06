<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> WebContent/jsp1/test1.jsp</h1>
	<h2> JSP 기본 요소 </h2>
	<h3> 1. 주석문 </h3>
	<h3> 2. JSP 지시어 </h3>
	<h3> 3. 스크립트 요소 </h3>
	<h3> 4. 액션 태그 </h3>
	
	<!-- HTML 주석 -->
	<%-- JSP 주석  --%>
	
	<script type="text/javascript">
		// JS 주석
		/* JS 주석 */
	</script>
	
	<%
		// java 주석
		/* java 주석 */
		/** java 주석 */
	%>
	
	
	<%
		// 2. JSP 지시어 (Directive) p.150~
		// < %@ 속성=값, 속성=값, ... ~ % > 로 만들어져 있는 형태.
		// < %@ page ~ % > : 페이지에 대한 설명
		// < %@ include ~ % > : 포함할 때 지시어 (액션태그)
		// < %@ taglib ~ % > : 태그를 새롭게 추가할 때 사용하는 지시어 (JSTL)
		// => 해당 파일에서 JSP 코드를 실행할 때, 어떤 방식으로 실행 할 건지 설명하는 코드
    	// https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types
		
    	
    	
    	// 3. 스크립트 요소 p.160~
		// => JSP 코드안에 java 코드를 사용가능하게 만드는 것
		// 3-1. 선언문 (Declare) : 멤버 변수, 멤버 메소드 선언
		// 3-2. 스크립틀릿 (Scriptlet)
		// 3-3. 표현식 (Expression)
		
	%>
	
	
	<h3> JSP - 선언문 </h3>
	
	<%!
		// 선언문 : 멤버변수, 멤버 메소드 선언 => JSP 페이지 어디서든 사용가능한 변수, 메소드
		// 선언문 선언 방식 : %! ~ %
		
		String name = "홍길동";
		
		public void method() {
			System.out.println("출력");	
		}
	
		// public void method2(); => 선언문 안에서 메소드 선언은 가능하지만, 호출은 불가
	
	%>
	
	<%!
		// 선언문을 이렇게 나누어 작성해도, 위의 선언문과 합쳐져 하나의 선언문으로 인식됨
		int age = 20;	// 선언문 안이라면 -> 멤버변수
	%>
	
	
	
	<h3> JSP - 스크립틀릿 </h3>
	
	<%
		// Java 코드를 작성할 수 있다.
		int num = 30;	// 지역변수
		method();		// 메소드 호출 가능 
	
	/*	public void method2() {
			이 구역 안에서는 메소드 선언 불가	
		}
	*/
	
	%>
	
	
	
	<h3> JSP - 표현식 </h3>
	
	<!-- 내가 선언한 동작(메소드의 리턴, 변수, 리터럴 값을 사용
		java코드를 html 화면에 출력하고 싶다면 표현식 사용
	 -->
	<%=1000	%>	<%-- 화면에 1000 출력 --%>
	<%=num %>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>
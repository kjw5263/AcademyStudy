<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('img').css('width', 250);
		
		// 특정 시간마다 동작 처리
		setInterval(function(){
			$('body').append($('img').first());
			
		}, 2000);
	});
</script>

<script type="text/javascript">
	// CDATA(unParesd Character Data) : 실제 적용되는 태그를 일반 문자로 처리하겠다는 의미(파싱X, html코두로 변경)-> 텍스트로 읽히기 이한 문장
	// PDATA(Parsed Character Data) : 실제 적용되는 태그를 태그 그대로 처리하겠다는 의미(파싱O, html 코드로 변경)
	


	// <!CDATA[
	// 참조변수 =  setInterval("JS실행코드", 시간 간격);
	//var i = 0;
	//var cnt = setInterval("console.log(i++);", 2000);  // 2초에 한번씩 i 증가
	// ]]>
	

</script>
</head>
<body>
<h1>WebContent/jq/test7.jsp</h1>

<img src="3.jpg">
<img src="1.jpg">
<img src="2.jpg">

<!-- clearInterval(참조변수) -->
<!-- <input type="button" value="멈춰!" onclick="clearInterval(cnt)"> -->
</body>
</html>
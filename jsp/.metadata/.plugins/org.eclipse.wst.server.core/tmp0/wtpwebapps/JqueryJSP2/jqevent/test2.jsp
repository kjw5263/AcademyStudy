<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('a').click(function(){
			$(this).css('background-color', "green");
			// 기본 기능- 하이퍼링크를 동작하지 않도록 하는 기능
			//event.preventDefault();
			// 페이지 이동 이벤트 X
			//return false;
			//-> 하이퍼링크 막기 2가지
			
			
			
			//return;  페이지 이동 O
			// $(this).unbind();  (X)
		});
		
		
		$('h3').click(function(){
			$(this).append("+");
			
			// 이벤트 종료 (한번만 실행하고 )
			$(this).unbind();
		})
	
		
		
		
		
		// ready 영역 안으로 들어와야 시작되는 것
		// textarea 에 글자를 입력 -> 200 자 이상일 경우 -> 글자색 빨강
		// 글자를 입력 할 때마다 글자수 만큼 감소해서 출력
		
		// 1) 키보드 입력 시 - 입력된 글자수 체크
		// 2) 200-글자수 => 원래 h2 태그에 표시
		$('textarea').keyup(function(){
			var content = $(this).val();
			$('#txtCnt').text(200-content.length);
			// alert(tmp);
			
			var colorCnt = 200 - content.length;
			// 글자의 길이가 200보다 크면 -> red
			// 글자의 길이가 200보다 작으면 Green
			if(colorCnt >= 0 ){	// 양수-200자 포함
				$("#txtCnt").css('color', 'black');
			} else {	// 음수 - 200 초과
				$("#txtCnt").css('color', 'red');
			}
			
		});
		
		
		
		
	});
	
</script>


</head>
<body>

<h1>WebContent/jsEvent/test2.jsp</h1>

<h2><a href="https://www.naver.com">네이버로 이동합니다!!</a></h2>
<h3>테스트</h3>


<hr>
<h2 id="txtCnt">200</h2>
<textarea rows="5" cols="70"></textarea>

</body>
</html>
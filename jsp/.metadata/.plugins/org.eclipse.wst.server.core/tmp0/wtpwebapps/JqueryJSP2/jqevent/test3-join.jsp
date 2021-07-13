<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(document).ready(function(){
			// 제출 버튼 클릭시(submit 이벤트 발생) -> 요소의 값을 입력했는지 체크
			$("#my_form").submit(function(){
				if($("#id").val() == ""){
					alert("아이디를 입력하세요");
					$("#id").focus();
					return false;
				}
				
				if($("#pw").val() == ""){
					alert("비밀번호를 입력하세요");
					$("#pw").focus();
					return false;
				}
				
				$('input[type=password]').keyup(function(){
					if($("#pw").val() != $("#pwcheck").val()){
						$("#result").text("비밀번호가 일치하지 않습니다.");
					} else {
						$("#result").text("비밀번호가 일치합니다..");
					}
					
				});
				
				
			}); // submit 이벤트가 발생했을 때~
			
		})
	});

</script>
</head>
<body>
<h1>WebContent/jsEvent/test3.jsp</h1>

<form action="a.jsp" id="my_form" onsubmit="">
<!--  해당요소에 id값(class) 부여해야해! but 개발자는 id많이 써요 -->
	<input type="text" placeholder="아이디" name="id" id="id">
	<input type="password" placeholder="비밀번호" name="pw" id="pw">
	<input type="password" placeholder="비밀번호 확인" name="pwcheck">
	<div id="result"></div>
	<input type="submit" value="제출">
	

</form>

</body>
</html>
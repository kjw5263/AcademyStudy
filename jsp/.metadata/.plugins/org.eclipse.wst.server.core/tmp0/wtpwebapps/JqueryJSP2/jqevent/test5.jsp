<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">



</style>
<script src="../js/jquery-3.6.0.js"></script>
<!-- 추가ㅣ 기능을 위한 추가 라이브러리 -->
<script src="../js/jquery.innerfade.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		 $('#news').innerfade({
			 animationtype:'slide',
			 speed:350,
			 type:"random"
		 });
	})
</script>
</head>
<body>

<ul id="news">

	<li><img src="../jq/1.jpg"></li>
	<li><img src="../jq/2.jpg"></li>
	<li><img src="../jq/3.jpg"></li>
</ul>


</body>
</html>
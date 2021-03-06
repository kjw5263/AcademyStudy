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
	  // h2 태그 글자색 변경
	  // 속성의 값을 정해주면 값을 지정해주는 것.
	  $('h2').css('color', 'red');
	
	  
	  // 속성명만 쓰면 값을 가져오는 것
	  var c = $('h2').css('color');
	  alert(c);
	  
	  
	  $('h2').css('background', 'black');
	  
	  // 체이닝 기법 : 여러가지 속성을 [. 연산자를 이용해서] 여러개 사용
	  $('h2').css('color', 'yellow').css('background', 'orange');
	  
	  $('h2').css({
		  color:'black',
		  background:'green'	  
	  });
	  
	  // 각 태그의 글자별로 색상을 변경
	  //https://api.jquery.com/css/#css-propertyName-function
	  var col = ['red', 'orange', 'yellow'];
	  
	  $('h2').css('color', function(index){
		  //alert("index : " + index);
		  return col[index];
	  });
	  
	  
	  // 여러개의 속성 사용 : 1)배열 사용해서 배경색 변경 2) 글자색 변경 black
	  $('h2').css({
		  color:function(i){
			  return col[i];
		  },
		  background:function(idx){
			  return col[idx];
		  }
	  });
	  
	  
	  
  });
</script>
</head>
<body>

<h1>WebContent/jq/test3.js</h1>

<h2> head-0 </h2>
<h2> head-1 </h2>
<h2> head-2 </h2>
<h2> head-3 </h2>


</body>
</html>
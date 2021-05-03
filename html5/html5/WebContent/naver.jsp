<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<script type="text/javascript">
	function to_ajax(){
		 
	    $.ajax({
	        type : 'get',
	        url : 'https://openapi.naver.com/v1/search/movie.xml?query=%EC%A3%BC%EC%8B%9D',
	        dataType : 'json',
	        beforeSend : function(xhr){
	            xhr.setRequestHeader("X-Naver-Client-Id", "Kyfh22pzlli_1dQYrgkl");
	            xhr.setRequestHeader("X-Naver-Client-Secret","rWZw6ljF9q");
	        },
	        error: function(xhr, status, error){
	            alert(error);
	        }
	        success : function(json){
	            alert(json)
	        },
	    });
	}
</script>
</head>
<body>
	
</body>
</html>
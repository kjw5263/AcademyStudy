<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	

	function onJoinCheck() {
		/* 아이디 확인 */
		if(document.fr.id.value==""){
			alert("아이디를 입력하세요.");
			document.fr.id.focus();
			return false;
		}
		
		/* 아이디 5~10자리 확인 */
		if((document.fr.id.value.length < 5) || (document.fr.id.value.length>10)){
			alert("아이디는 5~10자리 이내로 입력하세요.");
			document.fr.id.focus();
			return false;
		}
		
		/* 비밀번호 입력여부 확인 */
		if(document.fr.pass1.value==""){
			alert("비밀번호를 입력해주세요.");
			document.fr.pass1.focus();
			return false;
		}
		
		if(document.fr.pass2.value==""){
			alert("비밀번호 확인란을 입력해주세요.");
			document.fr.pass2.focus();
			return false;
		}
		
		if(!(document.fr.pass1.value == document.fr.pass2.value)){
			alert("비밀번호가 서로 일치하지 않습니다.");
			document.fr.pass1.focus();
			return false;
		}
		
		/* 이름 확인 */
		if(document.fr.name.value==""){
			alert("이름을 입력해주세요.");
			document.fr.name.focus();
			return false;
		}
		
		
		/* 주민번호 확인 */
		if(document.fr.jumin1.value.length != 6 ){
			alert("주민번호 앞자리는 6자리 입니다");
			document.fr.jumin1.focus();
			return false;
		}
		if(document.fr.jumin2.value.length != 7){
			alert("주민번호 뒷자리는 7자리 입니다");
			document.fr.jumin2.focus();
			return false;
		}
		
		
		/* 성별 체크 */
		if(document.fr.gender[0].checked == false && 
				document.fr.gender[1].checked == false) {
			alert("성별을 체크하세요");
			document.fr.gender[0].focus();
			return false;
		}
		
		/* 주민번호 확인 */
		if(document.fr.hobby[0].checked == false &&
				document.fr.hobby[1].checked == false && 
				document.fr.hobby[2].checked == false ){
			alert("취미를 체크하세요");
			document.fr.hobby[0].focus();
			return false;
		}
		
		/* 과목 선택 확인 */
		var idx = document.fr.subject.selectedIndex;
		if(document.fr.subject.options[idx].value == "" ){
			alert("과목을 선택하세요");
			document.fr.subject.focus();
			return false;
		}
		
		/* 메모 입력 확인 */
		if(document.fr.comment.value == ""){
			alert("남기고 싶은 말을 입력하세요");
			document.fr.comment.focus();
			return false;
		}
		
	}
	
	/* 성별 자동 체크 */
	function onCheckGender() {
		var s = document.fr.jumin2.value.charAt(0);
		if(s == 1 || s==3) document.fr.gender[0].checked=true;
		if(s == 2 || s==4) document.fr.gender[1].checked=true;
	}
</script>

</head>
<body>

<h1> 회원가입 : 2강의실 김지원 </h1>
<form action="ITWILLJOINPRO.jsp" name="fr" method="post" onsubmit="return onJoinCheck()">
<fieldset>
	<legend>ITWILL 회원가입</legend>
	
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="password" name="pass1"><br>
	비밀번호 확인 : <input type="password" name="pass2"><br>
	이름 : <input type="text" name="name"> <br>
	주민번호 : <input type="text" name="jumin1">-<input type="password" name="jumin2" onKeyUp="onCheckGender()"><br>
	성별 : <input type="radio" name="gender" value="남">남
		   <input type="radio" name="gender" value="여">여 <br>
	취미 : <input type="checkbox" name="hobby" value="여행">여행
			<input type="checkbox" name="hobby" value="독서">독서
			<input type="checkbox" name="hobby" value="영화감상">영화감상<br>
	좋아하는 과목 :
	<select name="subject">
		<option value="">선택하세요.</option>
		<option value="jsp">JSP</option>
		<option value="Java">Java</option>
		<option value="Android">Android</option>
		<option value="Web">Web</option>
		<option value="DataBase">DataBase</option>
	</select> <br> 
	
	한마디 : <textarea rows="10" cols="100" name="comment"></textarea>
	
	<hr>
	
	<input type="submit" value="회원가입">
	<input type="reset" value="처음으로">
</fieldset>
</form>

</body>
</html>
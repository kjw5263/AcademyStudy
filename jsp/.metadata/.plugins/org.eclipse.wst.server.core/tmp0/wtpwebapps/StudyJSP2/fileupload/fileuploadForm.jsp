<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일업로드</title>
</head>
<body>
 <h1>WebContent/fileUpload/fileUploadForm.jsp</h1>
 
 <!-- 파일은 내 컴퓨터 (서버 컴퓨터)의 HDD에 저장 - upload 폴더에 

(가상경로 - 외부에서 접근가능한 폴더)

D:\workspace_jsp2\jsp\StudyJSP2\WebContent\upload

(실제경로 - 외부에서 접근 불가능한 폴더)

D:\workspace_jsp2\jsp\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\StudyJSP2\upload -->
 
 
 <form action="fileuploadPro.jsp" method="post" enctype="multipart/form-data">
    <table border="1">
	  <tr>
	    <td>이름</td> <td><input type="text" name="name"></td>
	  </tr>
	  <tr>
	    <td>제목</td> <td><input type="text" name="subject"></td>
	  </tr>
	  <tr>
	    <td>파일</td> <td><input type="file" name="filename"></td>
	  </tr>
	  <tr>
	    <td colspan="2"><input type="submit" name="제출"></td>
	  </tr>
	</table>
 
 </form>
 
 
 
 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
//���̵� üũ���� Ȯ�� (���̵� �ߺ��� ��� = 0 , �ߺ��� �ƴҰ�� = 1 )
var idck = 0;
$(function() {
    //idck ��ư�� Ŭ������ �� 
    $("#idck").click(function() {
        
        //userid �� param.
        var userid =  $("#userid").val(); 
        
        $.ajax({
            async: true,
            type : 'POST',
            data : userid,
            url : "idcheck.do",
            dataType : "json",
            contentType: "application/json; charset=UTF-8",
            success : function(data) {
                if (data.cnt > 0) {
                    
                    alert("���̵� �����մϴ�. �ٸ� ���̵� �Է����ּ���.");
                    //���̵� ������ ��� �������� , �ƴϸ� �Ķ����� ó���ϴ� ������
                    $("#divInputId").addClass("has-error")
                    $("#divInputId").removeClass("has-success")
                    $("#userid").focus();
                    
                
                } else {
                    alert("��밡���� ���̵��Դϴ�.");
                    //���̵� ������ ��� �������� , �ƴϸ� �Ķ����� ó���ϴ� ������
                    $("#divInputId").addClass("has-success")
                    $("#divInputId").removeClass("has-error")
                    $("#userpwd").focus();
                    //���̵� �ߺ����� ������  idck = 1 
                    idck = 1;
                    
                }
            },
            error : function(error) {
                
                alert("error : " + error);
            }
        });
    });
});
 
 
</script>

</head>
<body>
<div class="form-group">
	<label for="user_id">���̵�</label>
		<input type="text" class="form-control" id="user_id" name="user_id" placeholder="ID" required>
<div class="check_font" id="id_check"></div>
</div>


</body>
</html>
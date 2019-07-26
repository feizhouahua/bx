<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div>
[学生流失管理]
	<form action="delstudent.html" method="post">
		<input type="hidden" value="${sistudent.id}" name="id"/>
		<input type="hidden" name="username" value="${loginUser.username }"/>
		<table>
			<tr><td>学生姓名</td><td>${sistudent.student_name}</td></tr>
			<tr>
				<td>是否退款?</td>
			</tr>
			<tr>
				<td>退款<input type="radio" name="refund" value="yes"/></td>
				<td>不退<input type="radio" name="refund" value="no"/></td>
				<td></td>
			</tr>
			<tr>
			<td>
				<textarea name="cause"></textarea>
			</td>
			</tr>
		</table>
			<input type="submit" value="提交"/>
	</form>
			<button><a href="queryStus.jsp">返回</a></button>
</div>
</body>
<script>
	$(":radio").click(function(){
		var da = $("[name='refund']");
		for(var i=0;i<da.length;i++){
			if(da[i].value=='no'&&da[i].checked==true){
				$("tr:eq(2) td:last").empty();
			}else if(da[i].value=='yes'&&da[i].checked==true){
				$("tr:eq(2) td:last").append("<input type='number' name='num'/>");
			}
		}
	})
</script>
</html>
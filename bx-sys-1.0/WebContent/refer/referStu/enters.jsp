<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
</head>
<body>
	<div>
	<form action="referadd.html" method="post">
		<table class="table table-hover">
			<tr><td>姓名：</td><td><input type="text" value="${refered.refername }" readonly="readonly" name="student_name"></td></tr>
			<tr><td>电话：</td><td><input type="text" value="${refered.tel}" readonly="readonly" name="Tel"></td></tr>
			<tr><td>QQ：</td><td><input type="text" value="${refered.QQ }" readonly="readonly" name="QQ"></td></tr>
			<tr><td>身份证：</td><td><input type="text" name="Id_card"></td></tr>
		</table>
		<input type="submit" value="提交" />
	</form>
	</div>
</body>
</html>
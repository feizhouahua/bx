<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>录入学籍</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<style type="text/css">
	#ahref{
		float: right;
		margin-left: 10px;
	}
	.table.table-striped{
		width: 500px;
		margin: 0px auto;
	}
</style>
</head>
<body>
<<<<<<< HEAD
	<div>
	<form action="referadd.html" method="post">
	<input type="hidden" name="referid" value="${refered.id }">
		<table class="table table-hover">
			<tr><td>姓名：</td><td><input type="text" value="${refered.refername }" readonly="readonly" name="student_name"></td></tr>
			<tr><td>电话：</td><td><input type="text" value="${refered.tel}" readonly="readonly" name="Tel"></td></tr>
			<tr><td>QQ：</td><td><input type="text" value="${refered.QQ }" readonly="readonly" name="QQ"></td></tr>
			<tr><td>身份证：</td><td><input type="text" name="Id_card"></td></tr>
		</table>
		<input type="submit" value="提交" />
	</form>
	</div>
=======
		<br>
		<br>
		<form action="referadd.html" method="post">
			<span style="font-size: 20px; font-weight: bolder;">[录入学籍]</span>
			 <input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回"> 
			 <input id="ahref" class="btn btn-sm btn-primary" type="submit" value="提交">
			<br>
			<br>
			<br>
			<br>
			<table class="table table-striped">
				<tr>
					<td>姓名：</td>
					<td><input type="text" value="${refered.refername }"
						readonly="readonly" name="student_name"></td>
				</tr>
				<tr>
					<td>电话：</td>
					<td><input type="text" value="${refered.tel}"
						readonly="readonly" name="Tel"></td>
				</tr>
				<tr>
					<td>QQ：</td>
					<td><input type="text" value="${refered.QQ }"
						readonly="readonly" name="QQ"></td>
				</tr>
				<tr>
					<td>身份证：</td>
					<td><input type="text" name="Id_card"></td>
				</tr>
			</table>
		</form>
>>>>>>> branch 'book' of https://github.com/feizhouahua/bx.git
</body>
</html>
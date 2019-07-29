<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看咨询学生</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<style type="text/css">
	#ahref{
		float: right;
	}
	.table.table-striped{
		width: 500px;
		margin: 0px auto;
	}
</style>
</head>
<body>
	<br><br>
	<span style="font-size: 20px;font-weight: bolder;">[查看咨询学生]</span>
	<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
	<br><br><br><br>
	<table class="table table-striped">
		<tr>
			<td>姓名：</td>
			<td>${refer.refername }</td>
		</tr>
		<tr>
			<td>电话：</td>
			<td>${refer.tel }</td>
		</tr>
		<tr>
			<td>QQ：</td>
			<td>${refer.QQ }</td>
		</tr>
		<tr>
			<td>咨询人：</td>
			<td>${refer.marketer }</td>
		</tr>
		<tr>
			<td>意向级别：</td>
			<td>${refer.intention_level }</td>
		</tr>
		<tr>
			<td>意向学科：</td>
			<td>${refer.intention_subject }</td>
		</tr>
		<tr>
			<td>来源：</td>
			<td>${refer.source }</td>
		</tr>
		<tr>
			<td>备注：</td>
			<td>${refer.remarks }</td>
		</tr>

		<tr>
			<td>跟踪信息</td>
			<td><a href="trackadd.jsp">添加跟踪</a></td>
		</tr>
	</table>
</body>
</html>
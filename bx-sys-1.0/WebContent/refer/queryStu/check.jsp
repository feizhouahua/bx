<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看报名学生</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
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
<<<<<<< HEAD
<table class="table table-hover">
<tr><td>姓名</td><td></td><td></td><td>${qrefer.refername }</td></tr>
<tr><td>电话</td><td></td><td></td><td>${qrefer.tel }</td></tr>
<tr><td>QQ</td><td></td><td></td><td>${qrefer.QQ }</td></tr>
<tr><td>咨询人</td><td></td><td></td><td>${qrefer.marketer }</td></tr>
<tr><td>意向级别</td><td></td><td></td><td>${qrefer.intention_level }</td></tr>
<tr><td>意向学科</td><td></td><td></td><td>${qrefer.intention_subject }</td></tr>
<tr><td>来源</td><td></td><td></td><td>${qrefer.source }</td></tr>
<tr><td>备注</td><td></td><td></td><td>${qrefer.remarks }</td></tr>
</table>
<a href="query.jsp">返回</a>
=======
	<br><br>
	<span style="font-size: 20px;font-weight: bolder;">[查看报名学生]</span>
	<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
	<br><br><br><br>
	<table class="table table-striped">
		<tr>
			<td>姓名:</td>
			<td>${qrefer.refername }</td>
		</tr>
		<tr>
			<td>电话:</td>
			<td>${qrefer.tel }</td>
		</tr>
		<tr>
			<td>QQ:</td>
			<td>${qrefer.QQ }</td>
		</tr>
		<tr>
			<td>咨询人:</td>
			<td>${qrefer.marketer }</td>
		</tr>
		<tr>
			<td>意向级别:</td>
			<td>${qrefer.intention_level }</td>
		</tr>
		<tr>
			<td>意向学科:</td>
			<td>${qrefer.intention_subject }</td>
		</tr>
		<tr>
			<td>来源:</td>
			<td>${qrefer.source }</td>
		</tr>
		<tr>
			<td>备注:</td>
			<td>${qrefer.remarks }</td>
		</tr>
	</table>
>>>>>>> branch 'book' of https://github.com/feizhouahua/bx.git
</body>
</html>
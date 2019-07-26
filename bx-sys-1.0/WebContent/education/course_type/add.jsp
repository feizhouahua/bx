<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程类别管理</title>
<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../../css/dashboard.css" rel="stylesheet">
<style type="text/css">
	#ahref{
		float: right;
		margin-left: 10px;
	}
	table{
		margin: 0px auto; 
		margin-top: 50px;
	}
	table tr td:nth-child(odd){
		padding-left:10px;
		font-weight: bolder;
	}
</style>
</head>
<body>
<form action="add.html" method="post">
<span style="font-size: 20px;font-weight: bolder;">[课程类别管理]</span>
<input id="ahref" class="btn btn-sm btn-primary" type="submit" value="保存"/>
<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
<table>
	<tr>
		<td>课程类别:</td>
		<td><input type="text" name="course_name"  required="required"/></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>总学时:</td>
		<td><input type="text" name="total_hours"  required="required"/></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>课程费用:</td>
		<td><input type="text" name="course_cost"  required="required"/></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="2">课程简介:</td>
	</tr>
	<tr>
		<td colspan="2"><textarea required="required" rows="8" cols="28" name="synopsis"></textarea></td>
	</tr>
</table>
</form>
</body>
</html>
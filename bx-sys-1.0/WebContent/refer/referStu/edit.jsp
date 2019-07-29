<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加/编辑咨询学生</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
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
	<br><br>
	<form action="upup.html" method="post">
	<span style="font-size: 20px;font-weight: bolder;">[添加/编辑咨询学生]</span>
	<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
	<input id="ahref" class="btn btn-sm btn-primary" type="submit" value="确定更改">
	<br><br><br><br>
		<input type="hidden" name="id" value="${xgrefer.id }">
		<table class="table table-striped">
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="refername"
					value="${xgrefer.refername }"></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><input type="text" name="tel" value="${xgrefer.tel }"></td>
			</tr>
			<tr>
				<td>QQ：</td>
				<td><input type="text" name="QQ" value="${xgrefer.QQ }"></td>
			</tr>
			<tr>
				<td>意向级别：</td>
				<td><select id="level" name="intention_level">
						<option value="A">A.已肯定，等时间</option>
						<option value="B">B.想报名，考虑中</option>
						<option value="C">C.考虑中，是否报</option>
				</select></td>
			</tr>

			<tr>
				<td>意向学科：</td>
				<td><select id="subject" name="intention_subject">
						<option value="JAVA">JAVA</option>
						<option value="UI">UI</option>
						<option value="WEB">WEB</option>
				</select> 意向班级: <select id="class" name="intention_class">
						<option value="JAVA1班">JAVA1班</option>
						<option value="UI1班">UI1班</option>
						<option value="WEB1班">WEB1班</option>
				</select></td>
			</tr>

			<tr>
				<td>来源：</td>
				<td><select id="source" name="source">
						<option value="QQ">QQ</option>
						<option value="微信">微信</option>
						<option value="广告">广告</option>
				</select></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td><input type="text" name="remarks"
					value="${xgrefer.remarks }"></td>
			</tr>
		</table>
		
	</form>
</body>
<script type="text/javascript">
	var level = $("#level>option");
	for (var i = 0; i < level.length; i++) {
		var num = level[i].value
		if (num == '${xgrefer.intention_level }') {
			level[i].selected = true;
		}
	}
	var cla = $("#class>option");
	for (var i = 0; i < cla.length; i++) {
		var num = cla[i].value
		if (num == '${xgrefer.intention_class }') {
			cla[i].selected = true;
		}
	}
	var subject = $("#subject>option");
	for (var i = 0; i < subject.length; i++) {
		var num = subject[i].value
		if (num == '${xgrefer.intention_subject }') {
			subject[i].selected = true;
		}
	}
	var source = $("#source>option");
	for (var i = 0; i < source.length; i++) {
		var num = source[i].value
		if (num == '${xgrefer.source }') {
			source[i].selected = true;
		}
	}
</script>
</html>
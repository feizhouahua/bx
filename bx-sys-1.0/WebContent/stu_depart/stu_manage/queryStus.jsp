<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<style type="text/css">
	#right{
		float: right;
	}
</style>
</head>
<body>
	<div>
		<form action="stus.html" method="post">
			<br><br>
			<span style="font-size: 20px;font-weight: bolder;">[在校学生管理]</span>
			<div id="right">
				<input class="btn btn-sm btn-primary" type="submit" value="高级查询">
				<a class="btn btn-sm btn-primary" href="add.html">添加</a>
			</div>
			<br><br><br>
			<div>
				查询条件：<input type="text" name="text" value="${text }">(姓名|电话|QQ|性别)
				课程类别： <select id="course" name="course">
					<option value="">---请选择---</option>
					<option value="java">java</option>
					<option value="ui">ui</option>
					<option value="web">web</option>
				</select> <select id="classname" name="classname">
					<option value="">---请选择---</option>
				</select>
			</div>
			<br><br>
		</form>
		<table class="table table-striped">
			<tr>
				<td>姓名</td>
				<td>入学时间</td>
				<td>班级</td>
				<td>QQ</td>
				<td>联系电话</td>
				<td>已付/应付学费</td>
				<td>状态</td>
				<td>编辑</td>
				<td>升级/转班</td>
				<td>查看</td>
				<td>流失</td>
			</tr>
			<c:forEach items="${students }" var="s">
				<tr>

					<td>${s.student_name }</td>
					<td>${s.admission_time }</td>
					<td>${s.classes.classname }</td>
					<td>${s.QQ }</td>
					<td>${s.tel }</td>
					<td>${s.tuition_paid }/${s.unpaid_tuition }</td>
					<td>${s.state }</td>
					<td><a
						href="upstu.html?text=${text }&page=${page}&name=${s.classes.classname}&id=${s.id}">编辑</a></td>
					<td>升级/转班</td>
					<td>查看</td>
					<td>流失</td>
				</tr>
			</c:forEach>
		</table>
		<div id="right" style="margin-top: 20px;">
		<a class="btn btn-xs btn-info" href="stus.html?text=${text }&page=1">首页</a> 
		<a class="btn btn-xs btn-info" href="stus.html?text=${text }&page=${page>1 ? page-1 : 1}">上一页</a>
		<a class="btn btn-xs btn-info" href="stus.html?text=${text }&page=${page < pagnums ? page +1: pagnums }">下一页</a>
		<a class="btn btn-xs btn-info" href="stus.html?text=${text }&page=${pagnums }">末页</a>
	</div>
	</div>
</body>
<script>
	
	var table=$("table tr").length;
	if(table<6){
		for(var i = 1; i<=(6-table);i++){
			$("table tr:last")
			.after("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><tr>");
		}	
	}

	$("#course").change(function() {
		var course = $("#course").val();
		var post = "";
		$("#classname option:gt(0)").remove();
		$.ajax({
			url : "./ajax/course.html",
			type : "post",
			data : {
				course : course
			},
			dataType : "json",
			success : function(cla) {
				$(cla).each(function(i, p) {
					post += "<option>" + cla[i].classname + "</option>";
				});
				$("#classname option").after(post);
			},
			error : function() {
				alert("ajax请求失败");
			},
		});
	});
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程类别</title>
<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../../css/dashboard.css" rel="stylesheet">
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<style type="text/css">
	#right{
		float: right;
	}
	.table.table-striped{
		height: 240px;
	}
</style>
</head>
<body>
	<div>
	  <form action="list.html?page=1" method="post">	
		<span style="font-size: 20px;font-weight: bolder;">[课程类别]</span>
			<div id="right"><input class="btn btn-sm btn-primary" type="submit" value="高级查询"/>&nbsp;<a class="btn btn-sm btn-primary" href="add.jsp">添加</a></div>
		<br><br>
			课程类别：<input type="text" name="course_name"/><br><br>
			课程简介：<input type="text" name="synopsis"/><br><br>
			总&nbsp;&nbsp;学&nbsp;&nbsp;时：<input id="hour" type="number" name="total_hours"/>至<input id="ghour" type="number" name="gtotal_hours"/><br><br>
			课程费用：<input id="cost" type="number" name="course_cost"/>至<input id="gcost" type="number" name="gcourse_cost"/>
	   </form>
	</div>
	<br>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>名称</th>
				<th>简介</th>
				<th>总学时</th>
				<th>收费标准</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${course_types}" var="course_type">
				<tr>
					<td>${course_type.id}</td>
					<td>${course_type.course_name}</td>
					<td>${course_type.synopsis}</td>
					<td>${course_type.total_hours}</td>
					<td>${course_type.course_cost}</td>
					<td><a id="up" href="updatea.html?id=${course_type.id}"><img
						 	src="../images/bianji.png"></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="right" style="margin-top: 20px;">
		<a class="btn btn-xs btn-info" href="list.html?page=1">首页</a> 
		<a class="btn btn-xs btn-info" href="list.html?page=${page>1?page-1:1}">上一页</a>
		<a class="btn btn-xs btn-info" href="list.html?page=${page<pages?page+1:pages}">下一页</a>
		<a class="btn btn-xs btn-info" href="list.html?page=${pages}">末页</a>
	</div>
<script type="text/javascript">

	var table=$("table tr").length;
	if(table<6){
		for(var i = 1; i<=(6-table);i++){
			$("table tr:last")
			.after("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><tr>");
		}	
	}
	
	
	
	$("#ghour").blur(function(){
		var a=$("#hour").val();
		var b=$("#ghour").val();
		if(b<a){
			alert("输入的数值必须比"+a+"大!");			
			$("#ghour").attr("required","required");
		}
	});
	$("#gcost").blur(function(){
		var c=$("#cost").val();
		var d=$("#gcost").val();
		if(d<c){
			alert("输入的数值必须比"+c+"大!");			
			$("#gcost").attr("required","required");
		}
	});
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部门管理</title>
<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../../css/dashboard.css" rel="stylesheet">
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<style type="text/css">
	#ahref{
		float: right;
	}
	.table.table-striped{
		height: 240px;
		margin-top: 60px;
	}
</style>
</head>
<body>
	<span style="font-size: 20px;font-weight: bolder;">[职务管理]</span>
	<a id="ahref" class="btn btn-sm btn-primary" href="add.jsp">添加</a>
	<br><br>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th colspan="2">部门名称</th>
				<th colspan="2">职务名称</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${posts}" var="post">
				<tr>
					<td>${post.id}</td>
					<td colspan="2">${post.department.depart_name}</td>
					<td colspan="2">${post.post_name}</td>
					<td><a href="updatea.html?id=${post.id}"><img
							src="../images/bianji.png"></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="ahref" style="margin-top: 20px;">
		<a class="btn btn-xs btn-info" href="list.html?page=1">首页</a> 
		<a class="btn btn-xs btn-info" href="list.html?page=${page>1?page-1:1}">上一页</a>
		<a class="btn btn-xs btn-info" href="list.html?page=${page<pages?page+1:pages}">下一页</a>
		<a class="btn btn-xs btn-info" href="list.html?page=${pages}">末页</a>
	</div>
</body>
<script type="text/javascript">
	var table=$("table tr").length;
	if(table<6){
		for(var i = 1; i<=(6-table);i++){
			$("table tr:last")
			.after("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><tr>");
		}	
	}
</script>
</html>